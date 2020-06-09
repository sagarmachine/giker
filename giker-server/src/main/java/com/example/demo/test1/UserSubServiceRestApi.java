package com.example.demo.test1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserSubServiceRepository;
import com.example.demo.model.City;
import com.example.demo.model.Coach;
import com.example.demo.model.UserSubService;

@CrossOrigin
@RestController
public class UserSubServiceRestApi<T> {

	
	@Autowired
	UserSubServiceRepository usersubservicerepo;
	
	@RequestMapping(value ="/getgivers/{subservicecode}")
	public List<UserSubService> getGivers(@PathVariable String subservicecode){
		
		List<Coach>l=null;
		List<UserSubService> l1=null;
		if(subservicecode.contains("COACH"))
		{ l1 = usersubservicerepo.findByGivercodeContaining("COACH");
		  return l1;
		
		}
		else return null;
	}
	
	@RequestMapping(value = "/deleteallusersubservice")
	public String delete() {
		
		usersubservicerepo.deleteAll();
		return "deleted";
	}
	
	
	@GetMapping("/getCityListBySubService")
	public List<City> getCityListBySubService(@RequestParam("subservice") String subservice){
	      List<City> result= new ArrayList<City>();
		
		List<UserSubService> list= usersubservicerepo.findDistinctBySubserviceCode(subservice);
		for(UserSubService temp:list) {
			
			result.add(temp.getCity());
		}
		
		return result;
	}
	
	
	
}
