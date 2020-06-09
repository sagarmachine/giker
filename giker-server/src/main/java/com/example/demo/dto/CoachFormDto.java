package com.example.demo.dto;

import org.jboss.logging.Logger;

import com.example.demo.dao.CityRepository;

public class CoachFormDto extends CommonFormDto{

	Logger logg = Logger.getLogger(CoachFormDto.class);

	
	public CoachFormDto(){
		super();
//		logg.info("-----------> Coach Dto");
//		setCityHash();
		
	}

	public CoachFormDto(String city, String location, String description, String achievemet, String experience,
			String instagram, String pincode) {
		super(city, location, description, achievemet, experience, instagram, pincode);
		// TODO Auto-generated constructor stub
	}

	
	public CoachFormDto(CityRepository cityrepo) {
		super(cityrepo);
	};
	
	
	
}
