package com.example.demo.service.ecommerce;

import java.util.HashMap;
import java.util.List;

import com.example.demo.model.ecommerce.Product;
import com.example.demo.model.ecommerce.ProductCategorySeller;

public interface IProductCategorySellerService {

	List<String> addsubserviceCategory(ProductCategorySeller[] pcs);

	List<ProductCategorySeller> findAll();

	boolean deleteById(int id);

	List<HashMap<String, String[]>> getProductCategoryByUserSubServiceCode(String usersubservice);

	HashMap<Integer,String> getProductCategoryBySubServiceCode(String code);

	ProductCategorySeller findById(int id);

	List<Product> getProductsBySellerCode(String seller);

	
	List<Product> getRemainingProductsBySellerCode(String seller);

}
