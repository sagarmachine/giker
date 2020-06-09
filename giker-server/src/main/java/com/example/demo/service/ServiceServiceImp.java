package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.ServiceRepository;
import com.example.demo.model.Service;


@org.springframework.stereotype.Service
public class ServiceServiceImp implements IServiceService {

	@Autowired
	ServiceRepository servicerepo;
	
	@Override
	public boolean addService(String name,String code,String description) {

		Service service=servicerepo.findByCodeAndName( code, name);
		if(service==null)
			{
			servicerepo.save(new Service (code,name,description));
			return true;
			}
		return false;
	}

	
}
