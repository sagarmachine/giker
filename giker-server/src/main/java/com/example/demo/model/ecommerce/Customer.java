package com.example.demo.model.ecommerce;

import java.util.List;

//@JsonIgnoreProperties(value= {"username"})



public class Customer {
	

	
	
//////////Fields
	private String username;
	
	private String name;
	
	private String primaryphone;
	
	private String email;
	
	private String requestedtime;
	
	

	

	private List<String> phone;
	
	private List<String> address;
	
	private int totalorders;
	
	private int pendingorders;
	
	private int confirmedorders;
	
	private int declinedorders;
	
////////////// Constructors----

	public Customer() {}
	
	
public Customer(String username, String name, String primaryphone) {
	super();
	this.username = username;
	this.name = name;
	this.primaryphone = primaryphone;
}


///////Getters and setters

public String getRequestedtime() {
	return requestedtime;
}


public void setRequestedtime(String requestedtime) {
	this.requestedtime = requestedtime;
}



	public String getUsername() {
		return username;
	}

	public int getTotalorders() {
		return totalorders;
	}


	public void setTotalorders(int totalorders) {
		this.totalorders = totalorders;
	}


	public int getPendingorders() {
		return pendingorders;
	}


	public void setPendingorders(int pendingorders) {
		this.pendingorders = pendingorders;
	}
	public int getConfirmedorders() {
		return confirmedorders;
	}


	public void setConfirmedorders(int confirmedorders) {
		this.confirmedorders = confirmedorders;
	}


	

	public int getDeclinedorders() {
		return declinedorders;
	}


	public void setDeclinedorders(int declinedorders) {
		this.declinedorders = declinedorders;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrimaryphone() {
		return primaryphone;
	}

	public void setPrimaryphone(String primaryphone) {
		this.primaryphone = primaryphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhone() {
		return phone;
	}

	public void setPhone(List<String> phone) {
		this.phone = phone;
	}

	public List<String> getAddress() {
		return address;
	}

	public void setAddress(List<String> address) {
		this.address = address;
	}
	
	
	
	
	

}
