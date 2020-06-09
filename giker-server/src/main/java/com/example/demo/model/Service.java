package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Service {

	
	//Column field  ----------------------------->
	@Id
   //@GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "code")
	String code;
	
	
	@Column(name="name")
	String name;
	
	@Column(name="description")
	String description;

	
	
	
	//Constructors and toString ----------------------------->
	
	
     public Service() {
    	 
     }
	public Service(String code, String name, String description) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Service [code=" + code + ", name=" + name + ", description=" + description + "]";
	}
	
	
	
	
	
	
	// Column field  Getters and setters ------------------->
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	// Relation fields -------------------------------->
	
	//SubService relation--------->
	
	@OneToMany( mappedBy = "servicecode",cascade =CascadeType.ALL,fetch = FetchType.LAZY)
	List<SubService> subservices;

public void addSubService(SubService subservice) {
	if(subservices==null)
		subservices=new ArrayList();
	subservices.add(subservice);
	subservice.setServicecode(this);
	
}

public void removeSubService(SubService subservice) {
	
	subservices.remove(subservice);
	subservice.setServicecode(null);
}


	public List<String> getSubservices() {
		List <String> l= new ArrayList();
		for(SubService s :subservices)
			l.add(s.getName());
		return l;
	}
	public void setSubservices(List<SubService> subservices) {
		this.subservices = subservices;
	}
	
	
	
	
	
	
	
}
