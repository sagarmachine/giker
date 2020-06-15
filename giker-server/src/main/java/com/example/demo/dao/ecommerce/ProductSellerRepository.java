package com.example.demo.dao.ecommerce;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ecommerce.ProductCategory;
import com.example.demo.model.ecommerce.ProductSeller;
import com.example.demo.model.ecommerce.Seller;
import org.springframework.data.jpa.repository.Query;

public interface ProductSellerRepository extends JpaRepository<ProductSeller, Integer> {
	
	//@Query("delete from ProductSeller where stock=0")
	//void deleteAllByStock(int stock);

	List<ProductSeller> findByStock(int s);
	
	List<ProductSeller> findBySellerAndProductCategoryid(Seller seller,ProductCategory pc);
	
	
	//List<ProductSeller>  findBySellerIdContaining(String subservice);


	//ProductSeller findByProductProductidAndSellerGivercode(int id, String sellercode);


	ProductSeller findByProductProductidAndSellerId(int id, String sellercode);


	List<ProductSeller> findByProductCategoryidAndSellerId(ProductCategory category, String subservice);


	List<ProductSeller> findBySellerId(String code);

}
