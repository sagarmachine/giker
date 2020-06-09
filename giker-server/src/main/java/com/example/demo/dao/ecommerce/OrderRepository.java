package com.example.demo.dao.ecommerce;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ecommerce.Order;
import com.example.demo.model.ecommerce.Seller;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	Integer countByGivercode(Seller s);

	List<Order> findByUsernameUsernameOrderByDate(String username);

	List<Order> findByGivercodeIdAndStatusOrderByDate(String sellercode, char status);

	List<Order> findByGivercodeIdAndDateeAndStatusOrderByDate(String sellercode, Date date,char status);

	List<Order> findByUsernameUsernameAndStatusOrderByDate(String username, char c);

}
