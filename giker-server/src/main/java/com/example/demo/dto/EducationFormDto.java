package com.example.demo.dto;

import com.example.demo.dao.CityRepository;

public class EducationFormDto extends CommonFormDto {
	
	
	String grade[]= new String[]{"ALL Levels"} ;
	
	String hometution="Y";

	
	
	public EducationFormDto() {
		// TODO Auto-generated constructor stub
	}

	public EducationFormDto(String city, String location, String description, String achievemet, String experience,
			String instagram, String pincode,String grade [],String hometution) {
		super(city, location, description, achievemet, experience, instagram, pincode);
		 this.grade=grade;
		 this.hometution=hometution;
		
		// TODO Auto-generated constructor stub
	}

	public EducationFormDto(CityRepository cityrepo) {

	super(cityrepo);
	}

	public String[] getGrade() {
		return grade;
	}

	public void setGrade(String[] grade) {
		this.grade = grade;
	}

	public String getHometution() {
		return hometution;
	}

	public void setHometution(String hometution) {
		this.hometution = hometution;
	}
	
	

}
