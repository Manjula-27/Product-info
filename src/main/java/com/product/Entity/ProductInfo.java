package com.product.Entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Table(name="Product")
@Entity
public class ProductInfo {

	
	 @Id
	 @GenericGenerator(name="product_Id", strategy="com.product.Entity.ProductGenerator")
     @GeneratedValue(generator ="product_Id")
	private String productId;
	 
	 @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "shopperId")
	    private ShopperInfo shopper;
	 
	 


	@Column(name ="category")
	 private String category;
	 
	 @Column(name ="brand")
	 private String brand;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setShopper(ShopperInfo shopper) {
		this.shopper = shopper;
	}

	public ProductInfo(String category, String brand) {
		

		this.category = category;
		this.brand = brand;
	}
	
	public ProductInfo() {
		
		
	}

	 
	 
	 

	
	 
	 
}
