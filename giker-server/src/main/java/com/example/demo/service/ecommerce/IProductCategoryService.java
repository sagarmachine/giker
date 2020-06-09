package com.example.demo.service.ecommerce;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.ecommerce.ProductCategory;


public interface IProductCategoryService {
	
	boolean addProductCategory(ProductCategory pc);

	boolean deleteById(int id);

	

	ProductCategory update(int id, ProductCategory pc);

	List<ProductCategory> findAll();

	ProductCategory findById(int id);

}
