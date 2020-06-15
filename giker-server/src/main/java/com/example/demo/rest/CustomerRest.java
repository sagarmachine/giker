package com.example.demo.rest;

import java.util.List;

import com.example.demo.dao.UserAddressRepository;
import com.example.demo.dao.UserPhoneRepository;
import com.example.demo.model.UserAddress;
import com.example.demo.model.UserPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ecommerce.Customer;
import com.example.demo.model.ecommerce.CustomerOrder;
import com.example.demo.service.ecommerce.ICustomerService;

@RestController
@CrossOrigin
public class CustomerRest {
	
	@Autowired
	ICustomerService customerservice;

	@Autowired
	UserAddressRepository userAddressRepository;

	@Autowired
	UserPhoneRepository userPhoneRepository;
	
	@GetMapping("/getCustomerDetail")
	public Customer getCustomerDetail(@RequestParam("username") String username )
    {
		return customerservice.getCustomerDetail(username);
    }
	
	@GetMapping("/getCustomerOrdersByUserName")
	public List<CustomerOrder> getCustomerOrdersByUserName(@RequestParam("username") String username) {
	
	
	return customerservice.getCustomerOrdersByUserName(username);
    }
	
	@GetMapping("/getCustomerPendingOrdersByUserName")
	public List<CustomerOrder> getCustomerPendingOrdersByUserName(@RequestParam("username") String username) {
		
		
		return customerservice.getCustomerPendingOrdersByUserName(username);
	    }
	
	@GetMapping("/getCustomerConfirmedOrdersByUserName")
	public List<CustomerOrder> getCustomerConfirmedOrdersByUserName(@RequestParam("username") String username) {
		
		
		return customerservice.getCustomerConfirmedOrdersByUserName(username);
	    }

	    @GetMapping("/getAddressList/{username}")
	public List<UserAddress> getAddressList(String username){

		return userAddressRepository.findByUseridUsername(username);

		}

	@GetMapping("/getPhoneList/{username}")
	public List<UserPhone> getPhoneList(String username){

		return userPhoneRepository.findByUseridUsername(username);

	}



	
}
