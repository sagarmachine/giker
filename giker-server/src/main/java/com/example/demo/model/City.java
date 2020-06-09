package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {

	
	//Column fields-------------->
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "city_name")
	String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public City() {}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + "]";
	}
	
	//Relation Field ----------------------------->
	
	
	@OneToMany(fetch =FetchType.LAZY, mappedBy = "city")
	List<UserSubService> usersubservices;


//	public List<UserSubService> getUsersubservices() {
//		return usersubservices;
//	}

public void setUsersubservices(List<UserSubService> usersubservices) {
		this.usersubservices = usersubservices;
	}

public void addUserSubService(UserSubService usersubservice) {
	
	if(usersubservices==null)
		usersubservices= new ArrayList();
usersubservices.add(usersubservice);
usersubservice.setCity(this);
}

	
}
