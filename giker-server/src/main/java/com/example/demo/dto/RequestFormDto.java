package com.example.demo.dto;

public class RequestFormDto {

	String message;
	
	String [] detailstoshare=new String[] {"phone","email","instagram"};

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String[] getDetailstoshare() {
		return detailstoshare;
	}

	public void setDetailstoshare(String[] detailstoshare) {
		this.detailstoshare = detailstoshare;
	}
	
	
	
	
}
