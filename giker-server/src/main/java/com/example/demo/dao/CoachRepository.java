package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Coach;

public interface CoachRepository extends JpaRepository<Coach,String> {

	
	
}
