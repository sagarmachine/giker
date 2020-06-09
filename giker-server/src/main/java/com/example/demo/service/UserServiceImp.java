package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.management.loading.PrivateClassLoader;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RequestRepository;
import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.Request;
import com.example.demo.model.Role;
import com.example.demo.model.User;

@Service
public class UserServiceImp implements IUserService{

	Logger logg =Logger.getLogger(UserServiceImp.class);
	
	
	@Autowired
	RequestRepository requestrepo;
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	RoleRepository rolerepo;
	
	public void registerUser(User user) {
	  
		Role role =rolerepo.findByRolename("USER");
		user.addRole(role);
		userrepo.save(user);
		
	}

	@Override
	public User findByUsername(String username) {
		Optional<User> user;
		
		user = userrepo.findById(username);
	if(user.isPresent())
		return user.get();
	return null;
	}

	@Override
	public User findByEmail(String email) {
Optional<User> user;
		user = userrepo.findByEmail(email);
	if(user.isPresent())
		return user.get();
	return null;
	}

	@Override
	public User findByPhone(String phone) {
		Optional<User> user;
		user = userrepo.findByPhone(phone);
	if(user.isPresent())
		return user.get();
	return null;
	}

	
}
