package com.example.demo.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddMyProductRequest {

	
	double myPrice;
	int productId;
	
	@JsonProperty("myPrice")
    public double getMyPrice() {
		return myPrice;
	}
	
	public void setMyPrice(double myPrice) {
		this.myPrice = myPrice;
	}
	@JsonProperty("productId")
  public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
}
