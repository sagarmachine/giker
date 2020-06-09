package com.example.demo.dto;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

public class UpdateProfileDto {

	String username;
	String email;
	String[] publicinfo;
	MultipartFile image;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String[] getPublicinfo() {
		return publicinfo;
	}
	public void setPublicinfo(String[] publicinfo) {
		this.publicinfo = publicinfo;
	}
	
	String instagram;
	
	
	 
	String dobstring;
	
	
	public void setDobstringTo(Date dob) {
		SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
		dobstring=formatter.format(dob);
	}
		public String getDobstring() {
		
		return dobstring;
	}

	public void setDobstring(String dobstring) {

		this.dobstring = dobstring;
	}
	
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	
	
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	@Override
	public String toString() {
		return "UpdateProfileDto [username=" + username + ", email=" + email + ", publicinfo="
				+ Arrays.toString(publicinfo) + "]";
	}
	
	
	
	
}
