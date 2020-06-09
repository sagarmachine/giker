package com.example.demo.dao.ecommerce;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ecommerce.ProductCategorySeller;

public interface ProductCategorySellerRepository extends JpaRepository<ProductCategorySeller, Integer> {

	ProductCategorySeller findFirstBySubserviceCode(String subservice);
	
	

}
