package com.example.demo.model.ecommerce;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.example.demo.model.SubService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "product_category_seller")
@JsonIgnoreProperties(value = { "productcategory","subservice" })
public class ProductCategorySeller {

	// Column
	// Fields----------------------------------------------------------------------------

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name = "product_category")
	private ProductCategory productcategory;

	
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name = "sub_service")
	private SubService subservice;
	
	


	@Transient
	private int categoryid;
	
	@Transient
	private String service;

	// Constructors----------------------------------------------------------------------
	public ProductCategorySeller() {
		super();
	}

	public ProductCategorySeller(ProductCategory productcategory, SubService subservice, int categoryid,
			String service) {
		super();
		this.productcategory = productcategory;
		this.subservice = subservice;
		this.categoryid = categoryid;
		this.service = service;
	}
	


	
	

	// Getter and Setter Methods----------------------------------------------
	public int getCategoryid() {
		return categoryid;
	}



	



	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}



	public String getService() {
		return service;
	}



	public void setService(String service) {
		this.service = service;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public ProductCategory getProductcategory() {
		return productcategory;
	}



	public void setProductcategory(ProductCategory productcategory) {
		this.productcategory = productcategory;
	}



	
	public SubService getSubservice() {
		return subservice;
	}



	public void setSubservice(SubService subservice) {
		this.subservice = subservice;
	}


	
	

	

	// toString method---------------------------------------------------

	



	

	@Override
	public String toString() {
		return "ProductCategorySeller [id=" + id + ", productcategory=" + productcategory.getProductcategory() + ", subservice=" + subservice.getCode()
				+ "]";
	}

}
