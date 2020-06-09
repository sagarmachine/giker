package com.example.demo.dao.ecommerce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.ecommerce.ProductCategory;


//@RepositoryRestResource(collectionResourceRel="springdataRestTestConfigs",path="springdataresttestConfigs")

@CrossOrigin
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer>{

	
}
