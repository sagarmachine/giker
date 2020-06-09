package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ecommerce.ProductCategory;
import com.example.demo.service.ecommerce.IProductCategoryService;
import com.example.demo.service.ecommerce.ProductSellerServiceImpl;
import com.example.demo.utility.IGeoLite;

@RestController
@CrossOrigin

public class ProductCategoryRest {
	
	Logger logg = Logger.getLogger(ProductSellerServiceImpl.class);
	
	@Autowired
	IGeoLite geoliteservice;
	

	@Autowired
	private IProductCategoryService categoryservice;

//	{
//		"productcategory":"Beverages"
//	}

	@GetMapping("/productcategory")
	public List<ProductCategory> findAll() {

		return categoryservice.findAll();

	}

	@GetMapping("/productcategory/{id}")
	public ProductCategory findById(@PathVariable int id) {
		

		return categoryservice.findById(id);

	}

	@PostMapping("/productcategory")
	public List<String> add(@RequestBody ProductCategory[] pc) {
	//testing city name----	
//		String cityname;
//		String ip = "2405:201:6c02:6fd9::c0a8:1d01";
//		// ip=request.getRemoteAddr();
//		cityname = geoliteservice.getCity(ip);
//		// GeoLite code
//		logg.info("city------------>" + cityname);
		
		
		List<String> result = new ArrayList<String>();
		for (ProductCategory temp : pc) {
			result.add(temp.getProductcategory() + "  " + categoryservice.addProductCategory(temp));
		}
		
		return result;
	}

	@PutMapping("/productcategory/{id}")
	public ProductCategory update(@PathVariable int id, @RequestBody ProductCategory pc) {

		return categoryservice.update(id, pc);
	}

	@DeleteMapping("/productcategory/{id}")
	public String deleteById(@PathVariable int id) {
		return id + " Deleted " + categoryservice.deleteById(id);

	}

}
