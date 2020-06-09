package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.demo.model.Service;
import com.example.demo.model.SubService;

public interface ISubServiceService {


	List<SubService> findByServicecode(Service string);

	boolean addSubService(String name, String code, String description, String servicecode, String imgsrc,String keyword);


	 String updateSubServce(String code, String name, String description, String imagesrc, String servicecoderest,
			String keyword);

	List<SubService> getSubServiceListToShow(HttpSession session);

	List<SubService> getSearchedSubServiceListToShow(HttpSession session, String search);


}
