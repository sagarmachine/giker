package com.example.demo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.example.demo.model.ecommerce.ProductCategorySeller;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SubService {

	
	//Column field  ----------------------------->
	@Id
   //@GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "code")
	String code;
	
	
	@Column(name="name")
	String name;
	
	@Column(name="description")
	String description;
	
	@Column(name="image_src")
	String imagesrc;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="service_code")
	Service servicecode;
	
	@Column(name ="keyword")
	String keyword;	
	
	@Column(name ="givers")
	int givers;	
	
	
	//Constructors and toString ----------------------------->
	
	
     public SubService() {
    	 
     }
 	
 	public SubService(String code, String name, String description) {
 		
 		this.code = code;
 		this.name = name;
 		this.description = description;
 	
 	}


	
public SubService(String code, String name, String description, String imagesrc,String keyword,int givers) {
		this.code = code;
		this.name = name;
		this.keyword = keyword;
		this.description = description;
		this.imagesrc = imagesrc;
		this.givers = givers;
	}

	// Column field  Getters and setters ------------------->
	



	public String getCode() {
		return code;
	}
	@Override
	public String toString() {
		return "SubService [code=" + code + ", name=" + name + ", description=" + description + ", imagesrc=" + imagesrc
				+ ", servicecode=" + servicecode.getCode() + ", keyword=" + keyword + ", givers=" + givers + ", usersubservices="
				+ usersubservices + ", servicecoderest=" + servicecoderest + "]";
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
public Service getServicecode() {
		return servicecode;
	}
public void setServicecode(Service servicecode) {
		this.servicecode = servicecode;
	}
	
public String getImagesrc() {
return imagesrc;
}

public void setImagesrc(String imagesrc) {
this.imagesrc = imagesrc;
}

public String getKeyword() {
return keyword;
}

public void setKeyword(String keyword) {
this.keyword = keyword;
}

public int getGivers() {
return givers;
}

public void setGivers(int givers) {
this.givers = givers;
}





	//Relation Fields------------------------------>

//One To Many with UserSubService--------->

@OneToMany(mappedBy = "subservice",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	List<UserSubService> usersubservices;


	public List<UserSubService> getUsersubservices() {
		return usersubservices;
	}

public void setUsersubservices(List<UserSubService> usersubservices) {
		this.usersubservices = usersubservices;
	}

public void addUserSubService(UserSubService usersubservice) {
	
	if(usersubservices==null)
		usersubservices= new ArrayList();
usersubservices.add(usersubservice);
usersubservice.setSubservice(this);
}


//ProductCategorySeller Realtion------------------------->
  
		@OneToMany(fetch=FetchType.LAZY, mappedBy = "productcategory",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE})
		@JsonIgnore
		Set<ProductCategorySeller> productcategorysellers;
		
		public void addProductCategorySeller(ProductCategorySeller p) {
			
			if(productcategorysellers==null)
				productcategorysellers=new HashSet<ProductCategorySeller>();
			
			productcategorysellers.add(p);
			
			p.setSubservice(this);
			
		}
		
		

		public Set<ProductCategorySeller> getProductcategorysellers() {
			return productcategorysellers;
		}

		public void setProductcategorysellers(Set<ProductCategorySeller> productcategorysellers) {
			this.productcategorysellers = productcategorysellers;
		}

		
		



//Fields for REST API------------------------------>
	
	




	@Transient
		String servicecoderest;
	public String getServicecoderest() {
			return servicecoderest;
		}
		public void setServicecoderest(String servicecoderest) {
			this.servicecoderest = servicecoderest;
		}
		
		
}
