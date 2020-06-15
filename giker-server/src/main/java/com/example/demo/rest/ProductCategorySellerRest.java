package com.example.demo.rest;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ecommerce.Product;
import com.example.demo.model.ecommerce.ProductCategorySeller;
import com.example.demo.service.ecommerce.IProductCategorySellerService;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class ProductCategorySellerRest {
	
//	{
//	
//	"categoryid":5,
//	"service":"GROCERY_SHOP"
//}

//-------ProductCategorySeller------(pcs)	
	
	@Autowired
	IProductCategorySellerService pcsservice;
	
	

	@PostMapping("/pcs")
	public List<String> addsubserviceCategory(@RequestBody ProductCategorySeller[] pcs ) {
		
		return pcsservice.addsubserviceCategory(pcs);
	}
	
	
	
	
	@GetMapping("/pcs")
	public List<ProductCategorySeller> findAll(){
		return pcsservice.findAll();
	}
	
	@GetMapping("/pcs/{id}")
	public ProductCategorySeller findbyId(@PathVariable int id){
		
		return pcsservice.findById(id);
		
	}
	
	//----------- getProductCategoriesBySubServiceCode------------------------------
	@GetMapping("/getProductCategoriesBySubServiceCode/{code}")
	public HashMap<Integer,String> getProductCategoryBySubServiceCode(@PathVariable String code)
	{
		return pcsservice.getProductCategoryBySubServiceCode(code); 
		
	}
	
	
	
	
	@CrossOrigin
	@GetMapping("/getProductCategoriesByUserSubServiceCode/{usersubservice}")
	public List<HashMap<String,String[]>> getProductCategoryByUserSubServiceCode(@PathVariable String usersubservice) {
		
		return pcsservice.getProductCategoryByUserSubServiceCode(usersubservice);
	

	}
	
	
	
	@DeleteMapping("/pcs/{id}")
	public String deleteById(@PathVariable int id){
		
		return "deleted  " + pcsservice.deleteById(id);
		
	
	}
	
	@GetMapping("/getProductsBySellerCode") 
	public List<Product> getProductsBySellerCode(@RequestParam("sellercode") String seller, HttpServletRequest req){
		return pcsservice.getProductsBySellerCode(seller);
	}
	
	@GetMapping("/getRemainingProductsBySellerCode") 
	public List<Product> getRemainingProductsBySellerCode(@RequestParam("sellercode") String seller){
		   
		        
		return pcsservice.getRemainingProductsBySellerCode(seller);
	}
	
	
}
