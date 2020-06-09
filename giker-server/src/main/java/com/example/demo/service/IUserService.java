package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Request;
import com.example.demo.model.User;

public interface IUserService {

	void registerUser(User user) ;
	
	User findByUsername(String username);

	User findByEmail(String email);

	User findByPhone(String phone);


	
	
}
