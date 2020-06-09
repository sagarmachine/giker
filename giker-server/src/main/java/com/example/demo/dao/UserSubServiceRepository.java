package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Coach;
import com.example.demo.model.Service;
import com.example.demo.model.User;
import com.example.demo.model.UserSubService;

public interface UserSubServiceRepository extends JpaRepository<UserSubService,String> {

	List<UserSubService> findByGivercodeContaining(String string);

	//List<UserSubService> findByUsername(User user);

	List<UserSubService> findByUser(User user);



	UserSubService findByUserAndSubserviceServicecode(User attribute, Service service);
	
	
    
	List<UserSubService> findDistinctBySubserviceCode(String subservice);

	
	

}
