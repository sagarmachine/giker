package com.example.demo.dao.ecommerce;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.City;
import com.example.demo.model.ecommerce.Seller;

public interface SellerRepository extends JpaRepository<Seller, String> {

	
	//Seller findByGivercode(String sellercode);


	
	List<Seller> findByIdContaining(String subservice);

	List<Seller> findByIdContainingAndGivercodeCity(String subservice, City city);

	List<Seller> findByIdContainingAndGivercodePincode(String subservice, String search);
}
