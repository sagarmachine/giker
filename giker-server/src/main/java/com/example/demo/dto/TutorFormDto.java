package com.example.demo.dto;

import com.example.demo.dao.CityRepository;

public class TutorFormDto extends CommonFormDto{
	
	String ownplace;
	
	String owntools;

	
	public TutorFormDto() {}
	
	
	public TutorFormDto(String city, String location, String description, String achievemet, String experience,
			String instagram, String pincode,String ownplace ,String owntools) {
		super(city, location, description, achievemet, experience, instagram, pincode);
		 this.ownplace=ownplace;
		 this.owntools=owntools;
		
		// TODO Auto-generated constructor stub
	}
	public TutorFormDto(CityRepository cityrepo) {
super(cityrepo);

	}


	public String getOwnplace() {
		return ownplace;
	}

	public void setOwnplace(String ownplace) {
		this.ownplace = ownplace;
	}

	public String getOwntools() {
		return owntools;
	}

	public void setOwntools(String owntools) {
		this.owntools = owntools;
	}

	
	
	
}
