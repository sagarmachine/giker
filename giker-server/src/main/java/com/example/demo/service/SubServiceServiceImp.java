package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ServiceRepository;
import com.example.demo.dao.SubServiceRepository;
import com.example.demo.dao.UserSubServiceRepository;
import com.example.demo.model.Service;
import com.example.demo.model.SubService;
import com.example.demo.model.User;
import com.example.demo.model.UserSubService;


@org.springframework.stereotype.Service
public class SubServiceServiceImp implements ISubServiceService {

	Logger logg = Logger.getLogger(SubServiceServiceImp.class);
	
	@Autowired
	SubServiceRepository subservicerepo;
	
	@Autowired
	ServiceRepository servicerepo;
	
	@Autowired
	UserSubServiceRepository usersubservicerepo;
	
	@Override
	public boolean addSubService(String name,String code,String description,String servicecode,String imgsrc,String keyword) {
		SubService subservice=subservicerepo.findByCodeAndName(code, name);
		if(subservice==null)
			{
			try{
				subservice= new SubService(code,name,description,imgsrc,keyword,0);
				Service s=servicerepo.findByCode(servicecode);
				s.addSubService(subservice);
				servicerepo.save(s);
				return true;
//			
			}catch(Exception ex) {
				
				logg.info("EXCEPTION--->"+ex);
			}
			}
		return false;
	}

	@Override
	public List<SubService> findByServicecode(Service servicecode ) {
     logg.info("-------------------------------------->");
		return	subservicerepo.findByServicecode(servicecode);
	}

	@Override
	public String updateSubServce(String code, String name, String description, String imagesrc,
			String servicecoderest,String keyword) {
		SubService subservice=subservicerepo.findByCode(code);
		if(subservice!=null)
			{
			try{

			    subservice= new SubService(code,name,description,imagesrc,keyword,0);
				
			    Service s=servicerepo.findByCode(servicecoderest);
			    s.addSubService(subservice);
				servicerepo.save(s);
				return "saved";
//			
			}catch(Exception ex) {
			logg.info("------------>"+ex+" ---> "+servicecoderest);
				return "SERVICE CODE "+servicecoderest+" not found";
			}
			}
	
		return "CODE: "+code +" notfound";
	}

	@Override
	public List<SubService> getSubServiceListToShow(HttpSession session) {
		User user =(User)session.getAttribute("user");
		List<UserSubService> usersubservices = usersubservicerepo.findByUser(user);
		List<SubService>subservices= subservicerepo.findAll();
		List<SubService>subservicestemp=new ArrayList<SubService>(subservices);
		if(usersubservices !=null) {
		for (SubService subservice :subservicestemp) {
			logg.info("insideeeeeeeeeeeee");
			 for(UserSubService usersubervice :usersubservices)
				 if(usersubervice.getGivercode().contains(subservice.getCode()))
					 subservices.remove(subservice);
			
		}
		}		return subservices;
	}

	@Override
	public List<SubService> getSearchedSubServiceListToShow(HttpSession session, String search) {
		List<SubService> subservices=	subservicerepo.findByKeywordContaining(search);
		
		User user =(User)session.getAttribute("user");
		List<UserSubService> usersubservices = usersubservicerepo.findByUser(user);
		List<SubService>subservicestemp=new ArrayList<SubService>(subservices);
		if(usersubservices !=null) {
		for (SubService subservice :subservicestemp) {
			 for(UserSubService usersubervice :usersubservices)
				 if(usersubervice.getGivercode().contains(subservice.getCode()))
					 subservices.remove(subservice);
			
		}
		}		return subservices;
	}



	
}
