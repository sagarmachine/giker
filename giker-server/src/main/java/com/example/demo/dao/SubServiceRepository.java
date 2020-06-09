package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Service;
import com.example.demo.model.SubService;

public interface SubServiceRepository extends JpaRepository<SubService,String> {

	SubService findByCodeAndName(String code, String name);

	List<SubService> findByServicecode(Service servicecode);

	@Modifying
	@Query("delete from SubService")
	void deleteAll();

	SubService findByCode(String code);

	
	@Transactional
	void deleteByCode(String code);

	//@Query("from SubService where keyword = LIKE '%?1%'")
	List<SubService> findByKeywordContaining(String search);

	List<SubService> findByCodeContaining(String string);

}
