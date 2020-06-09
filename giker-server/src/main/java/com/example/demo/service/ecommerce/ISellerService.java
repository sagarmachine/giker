package com.example.demo.service.ecommerce;

import java.util.List;

import com.example.demo.model.ecommerce.SellerOrder;
import com.example.demo.rest.dto.AddMyProductRequest;

public interface ISellerService {


	String addMyProduct(AddMyProductRequest product, String usersubservicecode);

	List<SellerOrder> getSellerPendingOrdersBySellerCode(String sellercode);

	List<SellerOrder> getSellerConfirmedOrdersBySellerCode(String sellercode);

	

	List<SellerOrder> getSellerConfirmedOrdersBySellerCodeAndDate(String sellercode, String date);

	
	
}
