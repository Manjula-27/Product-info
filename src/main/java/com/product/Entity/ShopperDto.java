package com.product.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class ShopperDto {
	
	@JsonProperty("prod")
	List<ProductDto> prod;

	public List<ProductDto> getProd() {
		return prod;
	}

}
