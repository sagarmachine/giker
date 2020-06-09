package com.example.demo.test1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.Role;
import com.example.demo.model.User;

@RestController
public class DataBaseConnectionTest {

	@Autowired
	UserRepository user;
	
	@Autowired
	RoleRepository role;
	
	@RequestMapping(value="/showusers")
	List<User>  showUsers() {
		
		return user.findAll();
		
	}
	@RequestMapping(value="/showroles")
	List<Role>  showroles() {
		
		return role.findAll();
		
	}
	@RequestMapping(value="/deleteallusers")
	String  deleteAllUsers() {
		
		user.deleteAll();
		return "DELETED";
		
	}
	@RequestMapping(value="/getusernames")
	List<String>  getUserNames() {
		
		
		return user.getusernames() ;
		
	}
	@RequestMapping(value="/getrole/{role1}")
	Role getRole(@PathVariable String role1) {
		
		return 	role.findByRolename(role1);
		
		
	}
	
	@RequestMapping(value="/addrole/{role1}")
	String addRole(@PathVariable String role1) {
		role.save(new Role (role1));
		
		return "ADDED";
		
	}
	
}
