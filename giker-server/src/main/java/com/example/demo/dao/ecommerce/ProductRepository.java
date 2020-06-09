package com.example.demo.dao.ecommerce;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ecommerce.Product;
import com.example.demo.model.ecommerce.ProductCategory;

public interface ProductRepository extends JpaRepository<Product,Integer>{

	Set<Product> findByCategoryidOrderByProductname(ProductCategory pc);

	List<Product> findByCategoryid(ProductCategory category);

	

}
