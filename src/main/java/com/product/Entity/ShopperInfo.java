package com.product.Entity;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name="ShopperInfo")
@Entity
public class ShopperInfo {
	
	 @Id 
	 @GenericGenerator(name="shopper_Id", strategy="com.product.Entity.ShopperIdGenerator")
     @GeneratedValue(generator ="shopper_Id")
	private String shopperId;
	  
	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "shopper", cascade = CascadeType.ALL)
	 private List<ProductInfo> prodList;

	public List<ProductInfo> getProdList() {
		return prodList;
	}

	public String getShopperId() {
		return shopperId;
	}

	public void setShopperId(String shopperId) {
		this.shopperId = shopperId;
	}

	public void setProdList(List<ProductInfo> prodList) {
		this.prodList = prodList;
	}
	 
	 
	 
	 

}
