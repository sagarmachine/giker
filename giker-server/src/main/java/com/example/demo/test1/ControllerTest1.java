package com.example.demo.test1;

import java.security.Principal;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.ServiceRepository;
import com.example.demo.model.SubService;
import com.example.demo.service.ISubServiceService;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional.Valuable;

@Controller
public class ControllerTest1 {
private Logger log = Logger.getLogger(ControllerTest1.class);

@Autowired
ISubServiceService subservice;
@Autowired
ServiceRepository servicerepo;

@RequestMapping(value = "/home")
	public String gethome() {
		System.out.println("INside Test");
		return "home";
	}
	
	@RequestMapping(value = "/login")
	public String geterror() {
		System.out.println("INside Test");
		return "login";
	}
	@RequestMapping(value = "/myprofile")
	public String getMyProfile() {
		System.out.println("INside Test");
		return "myprofile";
	}
	@RequestMapping(value="/loggedinuser")
	public String getLoggedInUser(Principal principal) {
		
		return principal.getName();
	}
	
	@ResponseBody
	@RequestMapping(value = "/getCoachService")
	public List<SubService> getCoachService(){
		
		return subservice.findByServicecode(servicerepo.findByCode("COACH"));
	}
}
