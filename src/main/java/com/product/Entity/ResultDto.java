package com.product.Entity;

import java.util.List;

public class ResultDto {
	
	private String shopperID;
	private List<ProductDto> shelf;
	public void setShopperID(String shopperID) {
		this.shopperID = shopperID;
	}
	public void setShelf(List<ProductDto> shelf) {
		this.shelf = shelf;
	}
	public String getShopperID() {
		return shopperID;
	}
	public List<ProductDto> getShelf() {
		return shelf;
	}
	
	
	

}
