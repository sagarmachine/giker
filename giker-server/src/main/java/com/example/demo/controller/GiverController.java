package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.CityRepository;
import com.example.demo.dao.RequestRepository;
import com.example.demo.dao.ServiceRepository;
import com.example.demo.dao.SubServiceRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dao.UserSubServiceRepository;
import com.example.demo.dto.CoachFormDto;
import com.example.demo.dto.EducationFormDto;
import com.example.demo.dto.OtherFormDto;
import com.example.demo.dto.ReviewDto;
import com.example.demo.dto.SellerFormDto;
import com.example.demo.dto.TutorFormDto;
import com.example.demo.model.Request;
import com.example.demo.model.Service;
import com.example.demo.model.SubService;
import com.example.demo.model.User;
import com.example.demo.model.UserSubService;
import com.example.demo.service.IRequestService;
import com.example.demo.service.IReviewService;
import com.example.demo.service.ISubServiceService;
import com.example.demo.service.IUserService;
import com.example.demo.service.IUserSubService;



@Controller
@RequestMapping(value = "/user")
public class GiverController {

	
	Logger logg= Logger.getLogger(GiverController.class);
	
	@Autowired
	IReviewService reviewservice;
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	IUserSubService usersubservicerepo ;
	
	@Autowired
	IRequestService requestservice;
	
	@Autowired
	UserSubServiceRepository ussr;
	
	@Autowired
	CityRepository cityrepo;
	
	@Autowired
	SubServiceRepository subservicerepo;

	@Autowired
	ISubServiceService subserviceservice;
	@Autowired
	ServiceRepository servicerepo;
	@Autowired
	IUserService userservice;
	
	
	
	@RequestMapping(value ="/showaddsubservicelist")
	public String showAddSubServiceList(Model model,HttpSession session) {
		
		 List<SubService>subservices= subserviceservice.getSubServiceListToShow(session);
		
		
		model.addAttribute("subservices",subservices);
		
		return "addsubservicelist";
	}
	
	@RequestMapping("/searchshowaddsubservicelist")
	public String searchShowAddSubServiceList(@RequestParam ("search") String search, Model model,HttpSession session) {
		search=search.toLowerCase();
		
		 List<SubService>subservices= subserviceservice.getSearchedSubServiceListToShow(session,search);

		

	
	if(subservices.size()==0)
		model.addAttribute("listsize",0);
	
	model.addAttribute("subservices",subservices);

		return "addsubservicelist";

	}

	
	
	

	// COACH---------------------------------------------
	@RequestMapping(value = "/coachform")
	public String coachForm(Model model,@RequestParam("subservice")String subservice) {
		
		CoachFormDto coachdto= new CoachFormDto(cityrepo);
		model.addAttribute("coachdto",coachdto);
		model.addAttribute("subservicecode",subservice);
	logg.info(coachdto.getCitylist());
		
		return "coachform";
	}
	
	
	
	
	
	@RequestMapping(value ="/addgivercoach")
	public String addGiverCoach(@ModelAttribute("coachdto") CoachFormDto coachdto,@RequestParam("subservicecode")String subservicecode,HttpSession session) {
		
		usersubservicerepo.addGiver(coachdto,subservicecode,((User)session.getAttribute("user")).getUsername());
		
		return "redirect:showmyprofile";
	}
	
	
	
	
	
	//Other--------------------------------------------------
	@RequestMapping(value = "/otherform")
	public String otherForm(Model model,@RequestParam("subservice")String subservice) {
		model.addAttribute("subservicecode",subservice);
		
		OtherFormDto otherdto = new OtherFormDto(cityrepo);
		model.addAttribute("otherdto",otherdto);

		return "otherform";
	}
	
	@RequestMapping(value ="/addgiverother")
	public String addGiverCoach(@ModelAttribute("otherdto") OtherFormDto otherdto,@RequestParam("subservicecode")String subservicecode,HttpSession session) {
		
		usersubservicerepo.addGiver(otherdto,subservicecode,((User)session.getAttribute("user")).getUsername());
		
		return "redirect:showmyprofile";
	}
	
	
	
//tutor -------------------------------------------
	
	
	
	@RequestMapping(value = "/tutorform")
	public String tutorForm(Model model,@RequestParam("subservice")String subservice) {
		model.addAttribute("subservicecode",subservice);

		TutorFormDto tutordto = new TutorFormDto(cityrepo);
		model.addAttribute("tutordto",tutordto);
		
		
		return "tutorform";
	}
	@RequestMapping(value ="/addgivertutor")
	public String addGiverTutor(@ModelAttribute("educationdto") TutorFormDto tutordto,@RequestParam("subservicecode")String subservicecode,HttpSession session) {
		
		usersubservicerepo.addGiver(tutordto,subservicecode,((User)session.getAttribute("user")).getUsername());
		
		return "redirect:showmyprofile";
	}
	
	
//Education----------------------------------->
	
	
	@RequestMapping(value = "/educationform")
	public String educationForm(Model model,@RequestParam("subservice")String subservice) {
		model.addAttribute("subservicecode",subservice);

		EducationFormDto educationdto = new EducationFormDto(cityrepo);
		
		model.addAttribute("educationdto",educationdto);
		
		
		return "educationform";
	}
	
	@RequestMapping(value ="/addgivereducation")
	public String addGiverEducation(@ModelAttribute("educationdto") EducationFormDto educationdto,@RequestParam("subservicecode")String subservicecode,HttpSession session) {
		
		usersubservicerepo.addGiver(educationdto,subservicecode,((User)session.getAttribute("user")).getUsername());
		
		return "redirect:showmyprofile";
	}
	

	@RequestMapping("/acceptrequest")
	public String acceptRequest(@RequestParam("user")String username,@RequestParam("usersubservice")String givercode) {
		
		//logg.info("111111112121111"+user+" -=-=-=-=-  "+usersubservice);
		
		User user = userrepo.findByUsername(username);
		
		UserSubService usersubservice = ussr.findById(givercode).get();
		
	//	String requestcode=user.getUsername()+"_"+usersubservice.getGivercode();
		 requestservice.acceptRequest(givercode,username);
		
		return "redirect:giverpendinglist?subservicecode="+usersubservice.getSubservice().getCode();
		
		
	}

	@RequestMapping("/declinerequest")
	public String declineRequest(@RequestParam("user")String username,@RequestParam("usersubservice")String givercode) {
		
		//logg.info("111111112121111"+user+" -=-=-=-=-  "+usersubservice);
		
		User user = userrepo.findByUsername(username);
		
		UserSubService usersubservice = ussr.findById(givercode).get();
		
	//	String requestcode=user.getUsername()+"_"+usersubservice.getGivercode();
		 requestservice.declineRequest(givercode,username);
		
		return "redirect:giverpendinglist?subservicecode="+usersubservice.getSubservice().getCode();
		
		
	}
	
	@RequestMapping("/giverfeedback")
	public String giverFeedback(@RequestParam("username")String username,@RequestParam("usersubservice")String givercode,@ModelAttribute("reviewdto")ReviewDto reviewdto) {
	
		UserSubService usersubservice= ussr.findById(givercode).get();
	
		User user = userservice.findByUsername(username);
		reviewservice.addGiverFeedback(user,usersubservice,reviewdto);
		
	return "redirect:giveracceptedlist?subservicecode="+usersubservice.getSubservice().getCode();
}
	
	@RequestMapping("/myshop")
	public String myShop(Model model,HttpSession session,HttpServletResponse res){
		
		try {
			Service service= servicerepo.findById("SHOP").get();
		UserSubService seller=ussr.findByUserAndSubserviceServicecode((User)session.getAttribute("user"),service);
		if(seller!=null) {
			logg.info("ALREADy EXIST <>><><><>");
			//res.sendRedirect("http://localhost:4200/seller/"+((User)session.getAttribute("user")).getUsername());
			return "redirect:http://localhost:3000/"+seller.getGivercode();//call angular
			}
		}catch(Exception ex) {
			logg.info("EXCEPTION --->myShop()");
		}
		
		
		SellerFormDto dto= new SellerFormDto(cityrepo,subservicerepo);
		model.addAttribute("dto",dto);
		return "sellerform";
	}
	
	@RequestMapping("/addmyshop")
	public String  addmyshop(Model model,@ModelAttribute("dto")SellerFormDto dto,HttpSession session) {
		
		String subservicecode= dto.getCategory();
		logg.info(subservicecode);
		
		usersubservicerepo.addGiver(dto,subservicecode,((User)session.getAttribute("user")).getUsername());

		
		return "redirect:showmyprofile";
	}
	
}
