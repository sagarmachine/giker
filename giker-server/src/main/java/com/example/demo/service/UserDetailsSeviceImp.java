package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Role;
import com.example.demo.model.User;

@Service 
public class UserDetailsSeviceImp implements UserDetailsService{

	@Autowired
	private UserServiceImp userservice;
	

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user=userservice.findByUsername(username);
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),user.getRoles());
	}

}
