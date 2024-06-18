package com.product.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class ProductDto {
	
	@NotNull
	@JsonProperty("brand")
	 private String brand;
	
	@NotNull
	@JsonProperty("category")
	 private String category;


	private String productId;

	public String getBrand() {
		return brand;
	}

	public String getCategory() {
		return category;
	}

	public String getProductId() {
		return productId;
	}

	public ProductDto( String productId) {
		this.productId = productId;
	}

	public ProductDto() {
		
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	
	
	
}
