package com.product.info.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.Entity.ProductInfo;
import com.product.Entity.ResultDto;
import com.product.Entity.ShopperDto;
import com.product.info.service.ProductInfoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/productApi")
public class ProductInfoController {
	
	@Autowired
	ProductInfoService productInfoService;
	
	
	@PostMapping("/info")
    public ResponseEntity<List<ProductInfo>> saveProductData(@Valid @RequestBody ShopperDto shopProductInfo, BindingResult res) {
		try {
	        return ResponseEntity.status(HttpStatus.OK).body(productInfoService.addProductInfo(shopProductInfo));
	    } catch (Exception e) {
	    	  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(productInfoService.addProductInfo(shopProductInfo));
	    }       
    }
	
	
	@GetMapping("/getProducts")
    public ResponseEntity<ResultDto> fetchProductsByShopper(@RequestParam(name="Id") String shopperId) {
		try {
	        return ResponseEntity.status(HttpStatus.OK).body(productInfoService.getProductsByShopperID(shopperId));
	    } catch (Exception e) {
	    	  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(productInfoService.getProductsByShopperID(shopperId));
	    }       
    }

}
