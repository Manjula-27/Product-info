package com.product.info.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.Entity.ProductDto;
import com.product.Entity.ProductInfo;
import com.product.Entity.ResultDto;
import com.product.Entity.ShopperDto;
import com.product.Entity.ShopperInfo;
import com.product.info.repo.ProductInfoRepository;
import com.product.info.repo.ShopInfoRepository;

import jakarta.validation.Valid;

@Service
public class ProductInfoService {
	
	@Autowired
	private ShopInfoRepository repo;

	public List<ProductInfo> addProductInfo(@Valid ShopperDto shopProductInfo) {
		// TODO Auto-generated method stub
		
		 ShopperInfo shopbject = new ShopperInfo();

			
		        List<ProductInfo> prodList = new ArrayList<>();
		        for (ProductDto prodObj : shopProductInfo.getProd()) {
		            
		        	ProductInfo prodInfo = new ProductInfo(prodObj.getCategory(), prodObj.getBrand());
		        	prodInfo.setShopper(shopbject);
		        	prodList.add(prodInfo);
		        }
		        
		       
		        shopbject.setProdList(prodList);
		        ShopperInfo s = repo.save(shopbject);
		        System.out.println("ShopperInfo save :: " + s);

		        System.out.println("Saved!!!");
		
		        return s.getProdList();
	}

	public ResultDto getProductsByShopperID(String shopperId) {
		ResultDto res= new ResultDto();
		Optional<ShopperInfo> result =	 repo.findByshopperId(shopperId);
		if(result.isPresent()) {
			
			ShopperInfo s=	result.get();
			res.setShopperID(s.getShopperId());
			List<ProductInfo> prodList = s.getProdList();
			List<ProductDto> prodDtoList = new ArrayList<>();
			for (ProductInfo prodObj : prodList) {
	            
				ProductDto prodInfo = new ProductDto();
				prodInfo.setProductId(prodObj.getProductId());
				prodDtoList.add(prodInfo);
				
	        }
			
			res.setShelf(prodDtoList);
			
		}
		return res;
	}

}
