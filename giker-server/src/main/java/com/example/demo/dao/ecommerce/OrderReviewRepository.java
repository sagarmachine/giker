package com.example.demo.dao.ecommerce;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ecommerce.OrderReview;
import com.example.demo.model.ecommerce.Seller;

public interface OrderReviewRepository extends JpaRepository<OrderReview, Integer> {

	Integer countByOrderidGivercode(Seller s);

	List<OrderReview> findByOrderidGivercode(Seller s);

}
