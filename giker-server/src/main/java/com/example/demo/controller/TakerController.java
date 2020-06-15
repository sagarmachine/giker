package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.text.DateFormatter;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.CoachRepository;
import com.example.demo.dao.EducationRepository;
import com.example.demo.dao.OtherRepository;
import com.example.demo.dao.RequestRepository;
import com.example.demo.dao.ServiceRepository;
import com.example.demo.dao.SubServiceRepository;
import com.example.demo.dao.TutorRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dao.UserSubServiceRepository;
import com.example.demo.dto.RequestFormDto;
import com.example.demo.dto.ReviewDto;
import com.example.demo.model.Coach;
import com.example.demo.model.Education;
import com.example.demo.model.Request;
import com.example.demo.model.SubService;
import com.example.demo.model.Tutor;
import com.example.demo.model.User;
import com.example.demo.model.UserSubService;
import com.example.demo.service.IRequestService;
import com.example.demo.service.IReviewService;
import com.example.demo.service.ISubServiceService;
import com.example.demo.service.IUserService;
import com.example.demo.service.IUserSubService;
import com.example.demo.utility.IGeoLite;

@Controller
@RequestMapping(value = "/user")
public class TakerController {
	
	
	@Autowired
	IGeoLite geoliteservice;
	
	@Autowired
	IRequestService requestservice;
	
	@Autowired
	IUserSubService usersubservice ;
	
	
	@Autowired
	RequestRepository requestrepo;
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	CoachRepository coachrepo;
	
	@Autowired
	EducationRepository educationrepo;
	
	@Autowired
	TutorRepository tutorrepo;
	
	@Autowired
	OtherRepository otherrepo;

	@Autowired
	ISubServiceService subserviceservice;
	@Autowired
	ServiceRepository servicerepo;
	@Autowired
	IUserService userservice;
	@Autowired
	UserSubServiceRepository usersubservicerepo;
	
	@Autowired
	SubServiceRepository subservicerepo;
	
	
	@Autowired
     IReviewService reviewservice;
	
	Logger logg = Logger.getLogger(TakerController.class);
	
	@RequestMapping(value = "/showslider")
	public String showSlider(Model model){
		List<SubService> subservicecoach=subserviceservice.findByServicecode(servicerepo.findByCode("COACH"));
		List<SubService> subserviceeducation=subserviceservice.findByServicecode(servicerepo.findByCode("EDUCATION"));
		List<SubService> subservicetutor=subserviceservice.findByServicecode(servicerepo.findByCode("TUTOR"));
		List<SubService> subserviceother=subserviceservice.findByServicecode(servicerepo.findByCode("OTHER"));
		List<SubService> subserviceseller=subserviceservice.findByServicecode(servicerepo.findByCode("SHOP"));

		model.addAttribute("subservicecoach",subservicecoach);
		model.addAttribute("subserviceeducation",subserviceeducation);
		model.addAttribute("subservicetutor",subservicetutor);
		model.addAttribute("subserviceother",subserviceother);
		model.addAttribute("subserviceseller",subserviceseller);
        model.addAttribute("coachslider",(int)Math.ceil((subservicecoach.size()/3.0)));
        model.addAttribute("educationslider",(int)Math.ceil((subserviceeducation.size()/3.0)));
        model.addAttribute("tutorslider",(int)Math.ceil((subservicetutor.size()/3.0)));
        model.addAttribute("otherslider",(int)Math.ceil((subserviceother.size()/3.0)));
        model.addAttribute("sellerslider",(int)Math.ceil((subserviceseller.size()/3.0)));


return "slider";
	}
	
	@RequestMapping(value = "/showsellerlist")
	public String  showsellerlist(@RequestParam("subservicecode") String subservicecode,HttpSession session)
	{
	//	logg.info("User-->"+req.getAttribute(""));
		
		return "redirect:http://localhost:3001/"+((User)session.getAttribute("user")).getUsername()+"/"+subservicecode;
 
	}
	
	@RequestMapping(value = "/showgiverlist")
	public String  showsgiverlist(HttpServletRequest request,@RequestParam("subservicecode") String subservicecode,@RequestParam("search")String search,HttpSession session ,Model model)
	{
		
		String ip="";
		String city="none";
		
		if(search.equals("none"))
			{
			 
			ip="2405:201:6c02:6fd9::c0a8:1d01";
			//ip=request.getRemoteAddr();
			city=geoliteservice.getCity(ip);
			//GeoLite code
			logg.info("city------------>"+city);
			}
		else {city=search;
		}
		
		 User user=(User)session.getAttribute("user");
		 List<UserSubService> usersubservices=null;
      
		
			if(Character.isDigit(search.charAt(0)))
	            
				usersubservices=usersubservice.getPincodeActiveGivers(subservicecode,user,search);

			else
             
				usersubservices=usersubservice.getCityActiveGivers(subservicecode,user,city);
		
		
		SubService subservice = subservicerepo.findByCode(subservicecode);
		model.addAttribute("dateformat",new SimpleDateFormat("dd-MM-yyyy"));

		model.addAttribute("usersubservices",usersubservices);
		
		model.addAttribute("reviewservice",reviewservice); 
		model.addAttribute("subservicecode",subservice.getCode());
		model.addAttribute("city",city);
		
		if(subservice.getServicecode().getCode().contains("COACH"))
		{	
			
			return "coachlist";
		}
		else if(subservice.getServicecode().getCode().contains("EDUCATION"))
		{
			return "educationlist";
		}
		else if(subservice.getServicecode().getCode().contains("TUTOR"))
		{	

			return "tutorlist";
		}else
			
			return "otherlist";	
	}
	
	
	@RequestMapping(value ="showgiverprofile")
	public String showGiverProfilr(@RequestParam("givercode") String givercode,@ModelAttribute("requestdto")RequestFormDto requestdto,Model model,HttpSession session ) {
		
		User user= (User)session.getAttribute("user");
		UserSubService primary=usersubservicerepo.findById(givercode).get();
		User giveruser=primary.getUser();
		List<UserSubService> secondaries= usersubservice.getSecondaries(givercode,giveruser);
		
		 Optional<Request> optinal= requestrepo.findById(user.getUsername()+"_"+primary.getGivercode());
		
		if(optinal.isPresent() )
			if( optinal.get().getRequeststatus()!='P')
			model.addAttribute("requestpending",false);
			
			else
		model.addAttribute("requestpending",true);
			
		model.addAttribute("dateformat",new SimpleDateFormat("dd-MM-yyyy"));
		model.addAttribute("primary",primary);
		model.addAttribute("giveruser",giveruser);
		model.addAttribute("secondaries",secondaries);
		model.addAttribute("reviewservice",reviewservice);

		if(givercode.contains("TUTOR"))
		{
			model.addAttribute("tutor",tutorrepo.findById(givercode).get());
		}
		else if(givercode.contains("EDUCATION")) {
			model.addAttribute("education",educationrepo.findById(givercode).get());
		}
		
		return "giverprofile";
	}
	
	@RequestMapping(value = "/sendrequest")
	public String sendRequest(@RequestParam("givercode")String givercode,@ModelAttribute("requestdto")RequestFormDto requestdto,HttpSession session) {
		User user=(User)session.getAttribute("user");
		
		logg.info("giver code----------->"+givercode);
     requestservice.addRequest(user.getUsername(),givercode,requestdto); 
		
		
		
		return "redirect:showgiverprofile?givercode="+givercode;
	}
	
	@RequestMapping("/takerfeedback")
	public String takerFeedback(@RequestParam("username")String username,@RequestParam("usersubservice")String givercode,@ModelAttribute("reviewdto")ReviewDto reviewdto) {
	
		UserSubService usersubservice= usersubservicerepo.findById(givercode).get();
	
		User user = userservice.findByUsername(username);
		reviewservice.addTakerFeedback(user,usersubservice,reviewdto);
		
	return "redirect:myacceptedlist";
}
	
	
	
}
