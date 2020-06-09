package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ecommerce.Product;
import com.example.demo.model.ecommerce.Seller;
import com.example.demo.rest.dto.AddMyProductRequest;
import com.example.demo.service.ecommerce.IProductSellerService;

@RestController
@CrossOrigin
public class ProductSellerRest {

	
	
	@Autowired
	private IProductSellerService productsellerservice;

	@GetMapping("/getProductsByCategoryIdAndSellerCode")
	public List<Product> getProductsByCategoryIdAndSellerCode(@RequestParam("id") int id,
			@RequestParam("sellercode") String code) {
		
		return productsellerservice.getProductsByCategoryIdAndSellerCode(id,code);
		

	}
	
	//gives all products of given category which are not choosen by particular seller 
	@GetMapping("/getProductsByCategoryIdAndSellerCode2")
	public List<Product> getProductsByCategoryIdAndSellerCode2(@RequestParam("id") int id,@RequestParam("sellercode") String seller){
		return productsellerservice.getProductsByCategoryIdAndSellerCode2(id,seller);
	}
	
	@GetMapping("/getSellerListBySubServiceCode/{subservice}")
	public List<Seller> getSellerListBySubServiceCode(@PathVariable String subservice ,@RequestParam("search") String search){
		
		return productsellerservice.getSellerListBySubServiceCode(subservice,search);
		
	}
	
	@DeleteMapping("/deleteMyProduct")
	public String deleteMyProduct(@RequestParam("id") int id,@RequestParam("sellercode") String sellercode ) {
		
	
		return  productsellerservice.deleteMyProduct(id,sellercode);
	}

	
	

	@PostMapping("/updateMyProductPrice")
	public void updateMyProductPrice(@RequestParam("sellercode") String sellercode,@RequestBody AddMyProductRequest productList[]) {
		
		productsellerservice.updateMyProductPrice(sellercode,productList);
		
	}
	
	
	
}

