package com.example.demo.service.ecommerce;

import java.util.List;

import com.example.demo.model.ecommerce.Product;
import com.example.demo.model.ecommerce.Seller;
import com.example.demo.rest.dto.AddMyProductRequest;

public interface IProductSellerService {

	List<Product> getProductsByCategoryIdAndSellerCode(int id, String code);

	List<Product> getProductsByCategoryIdAndSellerCode2(int id,String seller);

	List<Seller> getSellerListBySubServiceCode(String subservice, String search);

	String deleteMyProduct(int id, String sellercode);

	

      void updateMyProductPrice(String sellercode, AddMyProductRequest[] productUpdateList);

	

}
