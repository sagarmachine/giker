package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.CoachRepository;
import com.example.demo.dao.SubServiceRepository;
import com.example.demo.dao.UserSubServiceRepository;
import com.example.demo.dto.CoachFormDto;
import com.example.demo.dto.CommonFormDto;
import com.example.demo.model.Request;
import com.example.demo.model.User;
import com.example.demo.model.UserSubService;

public interface IUserSubService {

	
	
	
	void addGiver(CommonFormDto coachdto,String subservicecode,String username) ;


	List<UserSubService> getGivers(String subservicecode, User user);




	List<UserSubService> getSecondaries(String givercode, User giveruser);


	List<UserSubService> findmysubservicelist(User user);

	 int mySubServiceAcceptedNumber(UserSubService usersubservice);

	 int mySubServicePendingNumber(UserSubService usersubservice);


	List<Request> getGiverPendingList(String givercode);

	List<Request> getGiverAcceptedList(String givercode);


	List<UserSubService> getActiveGivers(String subservicecode, User user);


	List<UserSubService> getCityActiveGivers(String subservicecode, User user,String city);


	List<UserSubService> getPincodeActiveGivers(String subservicecode, User user, String pincode);



	
	
}
