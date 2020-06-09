package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;
@Service
public class SecurityServiceImpl implements ISecurityService {

	@Autowired
	UserDetailsService userdetailservice;
	
	
	@Autowired
	AuthenticationManager authenticationmanager;
	
	@Override
	public boolean login(String username, String password) {

		UserDetails userdetails=userdetailservice.loadUserByUsername(username);
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userdetails, password,userdetails.getAuthorities());
		
		authenticationmanager.authenticate(token);
		boolean result =token.isAuthenticated();
	if(result)
		SecurityContextHolder.getContext().setAuthentication(token);
		return result;
	}

}
