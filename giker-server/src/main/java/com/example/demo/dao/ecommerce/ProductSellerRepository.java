package com.example.demo.dao.ecommerce;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ecommerce.ProductCategory;
import com.example.demo.model.ecommerce.ProductSeller;
import com.example.demo.model.ecommerce.Seller;

public interface ProductSellerRepository extends JpaRepository<ProductSeller, Integer> {
	
	
	
	List<ProductSeller> findBySellerAndProductCategoryid(Seller seller,ProductCategory pc);
	
	
	//List<ProductSeller>  findBySellerIdContaining(String subservice);


	//ProductSeller findByProductProductidAndSellerGivercode(int id, String sellercode);


	ProductSeller findByProductProductidAndSellerId(int id, String sellercode);


	List<ProductSeller> findByProductCategoryidAndSellerId(ProductCategory category, String subservice);


	List<ProductSeller> findBySellerId(String code);

}
