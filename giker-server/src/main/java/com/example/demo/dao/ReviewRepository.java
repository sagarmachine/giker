package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Review;
import com.example.demo.model.User;
import com.example.demo.model.UserSubService;

public interface ReviewRepository extends JpaRepository<Review, Integer>{

	Review findByUsernameAndGivercode(User user, UserSubService usersubservice);

	
	
	
	//int getGiverSum(User user)


	@Query("select COUNT(ratinggiver) FROM Review where username=?1")
	Integer getTakerCount(User user);
	
	@Query("select SUM(ratinggiver) FROM Review where username=?1")
	Integer getTakerSum(User user);



	@Query("select COUNT(ratingtaker) FROM Review where givercode=?1")
     Integer getGiverCount(UserSubService givercode);
	
	@Query("select SUM(ratingtaker) FROM Review where givercode=?1")
    Integer getGiverSum(UserSubService givercode);
}
