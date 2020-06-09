package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserAddress;

public interface UserAddressRepository extends JpaRepository<UserAddress,Integer > {

	List<UserAddress> findByUseridUsername(String username);

}
