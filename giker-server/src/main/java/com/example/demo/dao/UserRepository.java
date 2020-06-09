package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User,String>{

	Optional<User> findByEmail(String email);

	Optional<User> findByPhone(String phone);

	@Query("select username from User")
	  List<String> getusernames();

	User findByUsername(String username);

	User findByUsernameContaining(String username);
	
}
