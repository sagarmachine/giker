package com.example.demo.service.ecommerce;

import java.util.List;

import com.example.demo.model.ecommerce.Product;

public interface IProductService {

	List<Product> findAllProductsByCategoryId(int id);

	Product findProductByProductId(int id);

	List<Product> add(Product[] p);


	Product update(int id, Product pc);

	boolean deleteById(int id);

	List<Product> findAll();

	

}
