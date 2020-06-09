package com.example.demo.dto;

import com.example.demo.dao.CityRepository;

public class OtherFormDto extends CommonFormDto {
	
	String keyword;

	
	public OtherFormDto() {}
	public OtherFormDto(String city, String location, String description, String achievemet, String experience,
			String instagram, String pincode,String keyword) {
		super(city, location, description, achievemet, experience, instagram, pincode);
		 this.keyword=keyword;
		// this.owntools=owntools;
		
		// TODO Auto-generated constructor stub
	}
	
	public OtherFormDto(CityRepository cityrepo) {
super(cityrepo);
	}
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	

}
