package com.example.demo.test1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.service.spi.InjectService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ServiceRepository;
import com.example.demo.dao.SubServiceRepository;
//import com.example.demo.entity.Customer;
import com.example.demo.model.Service;
import com.example.demo.model.SubService;
import com.example.demo.service.IServiceService;
import com.example.demo.service.ISubServiceService;


@RestController
public class AddingDeletingServicesDataAPI {

	Logger logg= Logger.getLogger(AddingDeletingServicesDataAPI.class);
	
	@Autowired
	IServiceService service;
	@Autowired
	ServiceRepository servicerepo;
	
	
	@Autowired
	SubServiceRepository subservicerepo;
	@Autowired
	ISubServiceService subservice;
//	@PostMapping(value = "/addservice")
//	public String addservice(@ResponseBody Service newservice) {
//		service.addService(newservice.getName(),newservice.getCode(),newservice.getDescription());
//		return "Added Successfully";
//	}
	@PostMapping(value="/addservices")
	public List<String> addService(@RequestBody List<Service> newservices) {
	List<String> result= new ArrayList();
		for(Service newservice:newservices)
			result.add(newservice.getCode() +"   "+newservice.getName() +"  "+service.addService(newservice.getName(),newservice.getCode(),newservice.getDescription()));
		return result;
	}
	
	@PostMapping(value="/addsubservices")
	public List<String> addSubService(@RequestBody List<SubService> newservices) {
	List<String> result= new ArrayList();
		for(SubService newservice:newservices)
			result.add(newservice.getCode() +"   "+newservice.getName() +"  "+subservice.addSubService(newservice.getName(),newservice.getCode(),newservice.getDescription(),newservice.getServicecoderest(),newservice.getImagesrc(),newservice.getKeyword()));
		return result;
	}
	
	@GetMapping("/deleteallsubservice")
	public String deleteAllSubService(String code) {
		subservicerepo.deleteAll();
		return "DELTED";
	}
	
	
	@GetMapping("/deletesubservice/{code}")
	public String deleteSubService(@PathVariable String code) {
		subservicerepo.deleteByCode(code);
		return "DELTED";
	}
	
	@GetMapping("/deleteallservice")
	public String deleteAllService(String code) {
		servicerepo.deleteAll();
		return "DELTED";
	}
	
	
	
	@PostMapping("/updatesubservices")
	   public List<String> updateSubServices(@RequestBody List<SubService> newservices) {
		List<String> result= new ArrayList();
		for(SubService newservice:newservices)
		result.add(subservice.updateSubServce(newservice.getCode(),newservice.getName(),newservice.getDescription(),newservice.getImagesrc(),newservice.getServicecoderest(),newservice.getKeyword()));
		return result;
	}
	@GetMapping("/getService/{code}")
	public Service getService(@PathVariable String code) {
		logg.info("-----------code="+code);
		return servicerepo.findByCode(code);
		
	} 
	
}
