package com.example.demo.rest;

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

import com.example.demo.model.ecommerce.Product;
import com.example.demo.service.ecommerce.IProductService;

@RestController
@CrossOrigin
public class ProductRest {
	
	
	Logger logg = Logger.getLogger(ProductRest.class);
	
	@Autowired
	IProductService productservice;
	
	
	
//	{
//	"productname":"Frooti",
//	"price":75,
//	"unit":"1/2 Litre",
//	"description":"World's Worst Drink",
//	"category_id":2
//	}
	
	
	@GetMapping("/product")
	public List<Product> findAllProducts(){
		
		return productservice.findAll();
	
	}
	
	
	
	
	
//-------- gives all products of given category	
	@GetMapping("findAllProductsByCategoryId/{id}")
	public List<Product> findAllProductsByCategoryId(@PathVariable int id)
	
	
	{ 
		return productservice.findAllProductsByCategoryId(id);
		
	}

	//get product by product id---
	@GetMapping("/product/{id}")
	public Product findProductByProductId(@PathVariable int id){
		return productservice.findProductByProductId(id);
		
		
	}
	
	@PostMapping("/product")
	public List<Product> add(@RequestBody Product[] p){
		return productservice.add(p);
		
    }
	
	@PutMapping("/product/{id}")
	public Product update(@PathVariable int id,@RequestBody Product pc ){
		return productservice.update(id,pc);
	}
	
	
	
	@DeleteMapping("/product/{id}")
	public String deleteById(@PathVariable int id){

		return "Product with id "+id+" deleted " + productservice.deleteById(id); 
		

	}
	
	



}
