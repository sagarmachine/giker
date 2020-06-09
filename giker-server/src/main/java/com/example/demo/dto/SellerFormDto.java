package com.example.demo.dto;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.CityRepository;
import com.example.demo.dao.SubServiceRepository;
import com.example.demo.dao.ecommerce.ProductCategoryRepository;
import com.example.demo.model.City;
import com.example.demo.model.SubService;
import com.example.demo.model.ecommerce.ProductCategory;

public class SellerFormDto extends CommonFormDto {
	
	String shopname;
	
	String secondaryphone;
	
	MultipartFile pic;
	
	char homedelivery='Y';
	
	String category;
	
	HashMap<String,String> categorylist;

	public SellerFormDto() {}
	
	public SellerFormDto(CityRepository cityrepo,SubServiceRepository categoryrepo) {
		super(cityrepo);
		categorylist= new HashMap<String, String>();
		
		List<SubService> categories= categoryrepo.findByCodeContaining("_SHOP");
		for(SubService cate: categories) {
			logg.info("name>>>>>"+cate.getName());
			categorylist.put(cate.getCode(),cate.getName());
		}
		}
	
	
	public HashMap<String, String> getCategorylist() {
		return categorylist;
	}


	public void setCategorylist(HashMap<String, String> categorylist) {
		this.categorylist = categorylist;
	}


	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getSecondaryphone() {
		return secondaryphone;
	}

	public void setSecondaryphone(String secondaryphone) {
		this.secondaryphone = secondaryphone;
	}

	public MultipartFile getPic() {
		return pic;
	}

	public void setPic(MultipartFile pic) {
		this.pic = pic;
	}

	public char getHomedelivery() {
		return homedelivery;
	}

	public void setHomedelivery(char homedelivery) {
		this.homedelivery = homedelivery;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "SellerFormDto [shopname=" + shopname + ", secondaryphone=" + secondaryphone + ", pic=" + pic
				+ ", homedelivery=" + homedelivery + ", category=" + category 
				 + ", city=" + city + ", location=" + location + ", description=" + description
				+ ", achievement=" + achievement + ", experience=" + experience + ", instagram=" + instagram
				+ ", pincode=" + pincode + "]";
	}


	


	
	
	

}
