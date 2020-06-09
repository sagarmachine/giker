package com.example.demo.dto;

import java.util.*;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.ApplicationContextUtils;
import com.example.demo.dao.CityRepository;
import com.example.demo.model.City;

import ch.qos.logback.core.joran.util.beans.BeanUtil;



public class CommonFormDto {

	Logger logg = Logger.getLogger(CommonFormDto.class);
	

	
	String city;
	
	String location;
	
	String description;
	
	String achievement;
	
	String experience="0-1 years";
	
	String instagram;
	
	String pincode;
	
	
	HashMap<String,String> citylist;
	
	public CommonFormDto() {}
	
	public CommonFormDto(String city, String location, String description, String achievemet, String experience,
			String instagram, String pincode) {
		super();
		this.city = city;
		this.location = location;
		this.description = description;
		this.achievement = achievemet;
		this.experience = experience;
		this.instagram = instagram;
		this.pincode = pincode;
	}

	public CommonFormDto(CityRepository cityrepo) {
		citylist= new HashMap<String, String>();
		List <City> cities=null;
		logg.info("--->cities="+cityrepo);
			cities= cityrepo.findAll();
		for(City c: cities) {
			logg.info(c.getId()+"  "+"  "+c.getName());
			citylist.put(c.getId()+"",c.getName());
		}
	}



	@Override
	public String toString() {
		return "CommonFormDto [city=" + city + ", location=" + location + ", description=" + description
				+ ", achievemet=" + achievement + ", experience=" + experience + ", instagram=" + instagram
				+ ", pincode=" + pincode + "]";
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAchievement() {
		return achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}



	public HashMap<String, String> getCitylist() {
	
		logg.info("---------->"+citylist.size());
		return citylist;
	}



	
	public void setCitylist(HashMap<String, String> citylist) {
		this.citylist = citylist;
	}
	
	
	
}
