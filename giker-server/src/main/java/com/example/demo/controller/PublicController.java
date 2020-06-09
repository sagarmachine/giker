package com.example.demo.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.*;
import com.example.demo.service.ISecurityService;
import com.example.demo.service.IUserService;
import com.example.demo.service.SecurityServiceImpl;

@Controller
//@RequestMapping(value = "/public")
public class PublicController {

	private Logger logg= Logger.getLogger(PublicController.class);
	
	@Autowired
	IUserService userservice;
	
@Autowired
private BCryptPasswordEncoder encoder;
	
@Autowired
ISecurityService securityservice;

	@RequestMapping(value="/")
	public String showHome(@ModelAttribute("user")User user) {
		
		return "home";
	}
	
	@RequestMapping(value="/showlogin")
	public String showLogin(@ModelAttribute("user") User user){
		return "login";
	}
	
	@RequestMapping(value="/loginuser")
	public String loginUser(@ModelAttribute("user") User user,HttpSession session,Principal principal){
		boolean result;
		try{ 
			result=securityservice.login(user.getUsername(),user.getPassword());
		}
		catch(Exception ex) {session.setAttribute("loginmsg","username or password is incorrect");
		return "redirect:/showlogin";}
		if(result) {
			User user1=userservice.findByUsername(user.getUsername());
            session.setAttribute("user",user1);

		return "redirect:/";}
		else {
			session.setAttribute("loginmsg","username or password is incorrect");
			return "redirect:/showlogin";
		}
	}
	
	
	
	@PostMapping(value ="/registeruser")
	public String registerUser(@ModelAttribute("user")User user, @RequestParam("passwordconfirmation")String password,Model m,HttpSession session) {
		
		user.setUsername(user.getUsername().trim());
		
		if(userservice.findByUsername(user.getUsername())!=null)
		     {m.addAttribute("registermsg","WARNING : try  using  different username ");
				return "home";
			
		     }
		else if(user.getPhone()!=null && (!user.getPhone().contains("^[0-9]*$") == true && user.getPhone().length()< 10)) {
			m.addAttribute("registermsg", "WARNING : invalid phone number");
			 return "home";	
		}
		else if(!password.equals(user.getPassword())) {
			m.addAttribute("registermsg", "WARNING : passwords did not match");
			 return "home";	
		}
		else if(user.getEmail()!=null && userservice.findByEmail(user.getEmail())!=null) {
			m.addAttribute("registermsg", "WARNING : email exist already");

			return "home";
		}else if(user.getPhone()!=null && userservice.findByPhone(user.getPhone())!=null) {
			m.addAttribute("registermsg", "WARNING : phone number exist already");
           return "home";
		}
		else {
			user.setPassword(encoder.encode(user.getPassword()));
			userservice.registerUser(user);
		    // m.addAttribute("registermsg", "Registered Sucessfully");
		     session.setAttribute("registermsg","Registerd Sucessfully");
		     return "redirect:/";
		}
		    
	}
	@RequestMapping("/simon")
	public String smimon() {
		
		return"simon";
	}
}
