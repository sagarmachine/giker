package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Service;

public interface ServiceRepository extends JpaRepository<Service,String> {

	Service findByCodeAndName(String id, String name);

	Service findByCode(String servicecode);


	
}
