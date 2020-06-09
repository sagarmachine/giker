package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserPhone;

public interface UserPhoneRepository extends JpaRepository<UserPhone, Integer> {

	List<UserPhone> findByUseridUsername(String username);

}
