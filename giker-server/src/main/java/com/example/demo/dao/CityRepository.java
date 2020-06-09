package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.City;

public interface CityRepository extends JpaRepository<City,Integer> {

	
	@Query("from City")
	public List<City> findAll();

	public City findByName(String search);
	
}
