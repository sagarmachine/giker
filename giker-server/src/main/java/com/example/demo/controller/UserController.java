package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.sql.Select;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.ServiceRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dto.ReviewDto;
import com.example.demo.dto.UpdateProfileDto;
import com.example.demo.model.Request;
import com.example.demo.model.Service;
import com.example.demo.model.SubService;
import com.example.demo.model.User;
import com.example.demo.model.UserSubService;
import com.example.demo.service.IRequestService;
import com.example.demo.service.IReviewService;
import com.example.demo.service.IServiceService;
import com.example.demo.service.ISubServiceService;
import com.example.demo.service.IUserService;
import com.example.demo.service.IUserSubService;
import com.example.demo.service.ReviewServiceImp;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	Logger logg=Logger.getLogger(UserController.class);
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	IRequestService requestservice;
	
	@Autowired
	IUserService userservice;
	
	@Autowired
	IUserSubService usersubserviceservice;
	
	@Autowired
	IReviewService reviewservice;
	
	@RequestMapping(value = "/showmyprofile")
	public String showMyProfile(Principal principal,Model model,HttpSession session){
		
		User user=userservice.findByUsername(principal.getName());
	
		List myaccepted=requestservice.getMyAccepted(user);
		 List mypending=requestservice.getMyPending(user);
	     List mydiclined=requestservice.getMyDiclined(user);
		
	      List<UserSubService> mysubservicelist=usersubserviceservice.findmysubservicelist(user);
	     
	     if(myaccepted !=null)
	     model.addAttribute("myaccepted",myaccepted.size());
	     else
		    model.addAttribute("myaccepted",0);

	     if(mypending !=null)
		     model.addAttribute("mypending",mypending.size());
		     else
			    model.addAttribute("mypending",0);
	     
	     if(mydiclined !=null)
		     model.addAttribute("mydiclined",mydiclined.size());
		     else
			    model.addAttribute("mydiclined",0);
	     
		model.addAttribute("user",user);
		model.addAttribute("mysubservicelist",mysubservicelist);
		model.addAttribute("usersubserviceservice",usersubserviceservice);
		
		model.addAttribute("reviewservice",reviewservice);
		
		return "myprofile";
	}
	
	@RequestMapping("/showupdatemyprofile")
	public String showUpdateMyProfile(Model model,HttpSession session) {
		
	  // User user1=(User)session.getAttribute("user");
		User user =userrepo.findByUsername(((User)session.getAttribute("user")).getUsername());

	   UpdateProfileDto updateprofiledto= new UpdateProfileDto();
	   updateprofiledto.setEmail(user.getEmail());
	   updateprofiledto.setUsername(user.getUsername());
	   updateprofiledto.setPublicinfo(user.getPublicinfo().split("_"));
	   updateprofiledto.setInstagram(user.getInstagram());
	 if(user.getDob()!=null)
	   updateprofiledto.setDobstringTo(user.getDob());
	   
	   
	   model.addAttribute("user",user);
	   model.addAttribute("updateprofiledto",updateprofiledto);
	   
		return "updatemyprofile";
	}
	
	@RequestMapping("/updatemail")
	public String updateEmail(@ModelAttribute("updateprofiledto") UpdateProfileDto updateprofiledto,HttpSession session) {
		logg.info(updateprofiledto);
		
		
		User user =userrepo.findByUsername(((User)session.getAttribute("user")).getUsername());
		logg.info("username--->"+user.getUsername());
		user.setEmail(updateprofiledto.getEmail());
		userrepo.save(user);
		
		
		return "redirect:showupdatemyprofile";
	}
	
	
	
	
	@RequestMapping("/updateinstagram")
	public String updateInstagram(@ModelAttribute("updateprofiledto") UpdateProfileDto updateprofiledto,HttpSession session) {
		User user =userrepo.findByUsername(((User)session.getAttribute("user")).getUsername());
		user.setInstagram(updateprofiledto.getInstagram());
		userrepo.save(user);
		
		
		return "redirect:showupdatemyprofile";
	}
	
	

	@RequestMapping(value = "/updatepublicinfo")
	public String updatePublicInfo(@ModelAttribute("updateprofiledto") UpdateProfileDto updateprofiledto,HttpSession session){
		
	
		User user =userrepo.findByUsername(((User)session.getAttribute("user")).getUsername());

		String publicinfo="";	
		for(String s:updateprofiledto.getPublicinfo()) {
			publicinfo=publicinfo+"_"+s;
		}
		if(publicinfo.length()>1)
		publicinfo=publicinfo.substring(1);
		user.setPublicinfo(publicinfo);
		userrepo.save(user);
		
		return "redirect:showupdatemyprofile";
		
	}
	
	@RequestMapping("/updateimage")
	public String updateImage(@ModelAttribute("updateprofiledto") UpdateProfileDto updateprofiledto,HttpSession session) {
		
		User user =userrepo.findByUsername(((User)session.getAttribute("user")).getUsername());

		try {
			user.setImage(updateprofiledto.getImage().getBytes());
		} catch (IOException e) {
			logg.info("EXCEPTION-->"+e);
		}
		
		userrepo.save(user);
		
		
		return "redirect:showmyprofile";
	}
	
	
	@RequestMapping("/updatedob")
	public String updateDob(@ModelAttribute("updateprofiledto") UpdateProfileDto updateprofiledto,HttpSession session) {
	
		User user =userrepo.findByUsername(((User)session.getAttribute("user")).getUsername());
		Date dob=null;
		try {
			dob= new SimpleDateFormat("dd/MM/yyyy").parse(updateprofiledto.getDobstring());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			logg.info("DAte Formatting EXc..-->"+e);		
			}
		
		user.setDob(dob);
		userrepo.save(user);
		
		return "redirect:showupdatemyprofile";

	}
	
	
	@RequestMapping("/myacceptedlist")
	public String myAcceptedList(Model model,HttpSession session,@ModelAttribute("reviewdto")ReviewDto reviewdto) {
		
User user =(User)session.getAttribute("user");
		
		List<Request> myacceptedlist= requestservice.getMyAccepted(user);
		model.addAttribute("myacceptedlist",myacceptedlist);

		SimpleDateFormat dateformatter= new SimpleDateFormat("dd-MM-YYYY");
		model.addAttribute("dateformatter",dateformatter);
		
		model.addAttribute("reviewservice",reviewservice);
		
		return "myacceptedlist";
	}
	
	
	@RequestMapping("/mypendinglist")
	public String myPendingList(Model model,HttpSession session) {
		
		User user =(User)session.getAttribute("user");
		
		List<Request> mypendinglist= requestservice.getMyPending(user);
		model.addAttribute("mypendinglist",mypendinglist);
		model.addAttribute("reviewservice",reviewservice);

		
		return "mypendinglist";
	}
	
	
	@RequestMapping("/mydeclinedlist")
	public String myDeclinedList(Model model,HttpSession session) {
		
User user =(User)session.getAttribute("user");
		
		List<Request> mydeclinedlist= requestservice.getMyAccepted(user);
		model.addAttribute("mydeclinedlist",mydeclinedlist);
		
		return "mydeclinedlist";
	}
	
	
	@RequestMapping("/giverpendinglist")
	public String giverPendingList(@RequestParam("subservicecode")String subservicecode,HttpSession session,Model model) {
		
		User user=(User)session.getAttribute("user");
		String givercode=user.getUsername()+"_"+subservicecode;
		List<Request> giverpendinglist=usersubserviceservice.getGiverPendingList(givercode);
		model.addAttribute("giverpendinglist",giverpendinglist);
		
		SimpleDateFormat dateformatter= new SimpleDateFormat("dd-MM-YYYY");
		model.addAttribute("dateformatter",dateformatter);
		
		model.addAttribute("reviewservice",reviewservice);

		return "giverpendinglist";
	}
	
	
	@RequestMapping("/giveracceptedlist")
	public String giverAcceptedList(@RequestParam("subservicecode")String subservicecode,HttpSession session,Model model,@ModelAttribute("reviewdto")ReviewDto reviewdto) {
		
		User user=(User)session.getAttribute("user");
		String givercode=user.getUsername()+"_"+subservicecode;
		List<Request> giveracceptedlist=usersubserviceservice.getGiverAcceptedList(givercode);
		model.addAttribute("giveracceptedlist",giveracceptedlist);
		SimpleDateFormat dateformatter= new SimpleDateFormat("dd-MM-YYYY");
		model.addAttribute("dateformatter",dateformatter);
		
		model.addAttribute("reviewservice",reviewservice);

		return "giveracceptedlist";
	}
	
	
}


