package com.example.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CityRepository;
import com.example.demo.dao.CoachRepository;
import com.example.demo.dao.EducationRepository;
import com.example.demo.dao.OtherRepository;
import com.example.demo.dao.SubServiceRepository;
import com.example.demo.dao.TutorRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dao.UserSubServiceRepository;
import com.example.demo.dao.ecommerce.SellerRepository;
import com.example.demo.dto.CoachFormDto;
import com.example.demo.dto.CommonFormDto;
import com.example.demo.dto.EducationFormDto;
import com.example.demo.dto.OtherFormDto;
import com.example.demo.dto.SellerFormDto;
import com.example.demo.dto.TutorFormDto;
import com.example.demo.model.City;
import com.example.demo.model.Coach;
import com.example.demo.model.Education;
import com.example.demo.model.Other;
import com.example.demo.model.Request;
import com.example.demo.model.SubService;
import com.example.demo.model.Tutor;
import com.example.demo.model.User;
import com.example.demo.model.UserSubService;
import com.example.demo.model.ecommerce.Seller;

@Service
public class UserSubServiceImp implements IUserSubService {

	Logger logg = Logger.getLogger(UserSubServiceImp.class);

	
	@Autowired
	OtherRepository otherrepo;
	
	
	@Autowired
	TutorRepository tutorrepo;
	
	@Autowired
	EducationRepository educationrepo;

	@Autowired
	UserRepository userrepo;

	@Autowired
	UserSubServiceRepository usersubservicerepo;

	@Autowired
	CityRepository cityrepo;

	@Autowired
	CoachRepository coachrepo;

	@Autowired
	SubServiceRepository subservicerepo;
	
	@Autowired
    IRequestService requestservice;
	
	@Autowired
	SellerRepository sellerrepo;

	public void addGiver(CommonFormDto dto, String subservicecode, String username) {

		City city = (cityrepo.findById(Integer.parseInt(dto.getCity()))).get();

		User user = userrepo.findByUsername(username);

		SubService subservice = subservicerepo.findByCode(subservicecode);

		UserSubService usersubservice = new UserSubService(new Date(), 'A', city, dto.getLocation(),
				dto.getDescription(), dto.getAchievement(), dto.getExperience(), dto.getInstagram(), dto.getPincode());

		usersubservice.setGivercode(username + "_" + subservicecode);

		usersubservice.setUser(user);

		usersubservice.setSubservice(subservice);

		logg.info(subservice);

		subservice.setGivers(subservice.getGivers() + 1);

		user.addUserSubService(usersubservice);

		city.addUserSubService(usersubservice);

		
		
		
		
		logg.info("33333333333333");
		subservicerepo.save(subservice);

		logg.info("444444444444");
		userrepo.save(user);

		

		if (dto instanceof CoachFormDto)
			addGiverCoach(usersubservice,city);

		else if (dto instanceof EducationFormDto)
			addGiverEducation(usersubservice, (EducationFormDto) dto,city);
        
		else if(dto instanceof TutorFormDto)
			addGiverTutor(usersubservice,(TutorFormDto)dto,city);
		
		else if(dto instanceof SellerFormDto){
			try{addGiverSeller(usersubservice,(SellerFormDto)dto,city);
			}catch(Exception ex) {
				logg.info("IMAGE"+ex);
				}
		}
		else if(dto instanceof OtherFormDto)
			addGiverOther(usersubservice,(OtherFormDto)dto,city);
		
	}

	private void addGiverSeller(UserSubService usersubservice, SellerFormDto dto, City city) throws IOException {
		Seller seller= new Seller(dto.getShopname(), dto.getLocation(),dto.getSecondaryphone(),dto.getHomedelivery(), dto.getPic().getBytes());
usersubservice.setSeller(seller);


usersubservicerepo.save(usersubservice);

cityrepo.save(city);

}

	private void addGiverOther(UserSubService usersubservice, OtherFormDto dto,City city) {

		Other other = new Other(dto.getKeyword());
	usersubservice.setOther(other);
	usersubservicerepo.save(usersubservice);
    cityrepo.save(city);
	//otherrepo.save(other);
		
	}

	private void addGiverTutor(UserSubService usersubservice, TutorFormDto dto,City city) {

		Tutor tutor = new Tutor(dto.getOwnplace(),dto.getOwntools());
		usersubservice.setTutor(tutor);
logg.info("1111111111");
		
		usersubservicerepo.save(usersubservice);
	   
		logg.info("222222222222");
		
		cityrepo.save(city);
		logg.info("55555555555");
	//	tutorrepo.save(tutor);
		
		logg.info("66666666666666");
	}

	private void addGiverEducation(UserSubService usersubservice, EducationFormDto dto,City city) {
		String grade = "";

		if (dto.getGrade().length == 0)
			grade = "N/A";
		if (dto.getGrade().length == 1)
			grade = dto.getGrade()[0];
		else {
			for (String s : dto.getGrade()) {
                if(s.equals("ALL Levels")) 
                {grade=s;
                	break;
                }
				grade = grade+ " "+s;
                 
			}
		}

		Education education = new Education(dto.getHometution(), grade);
		usersubservice.setEducation(education);
		usersubservicerepo.save(usersubservice);
	    cityrepo.save(city);
		//educationrepo.save(education);
	}

	void addGiverCoach(UserSubService usersubservice,City city) {
		Coach coach = new Coach();
		usersubservice.setCoach(coach);
		usersubservicerepo.save(usersubservice);
	    cityrepo.save(city);
		//coachrepo.save(coach);

	}



	@Override
	public List<UserSubService> getGivers(String subservicecode, User user) {
		List<UserSubService> usersubservices=usersubservicerepo.findByGivercodeContaining(subservicecode);
		List<UserSubService> usersubservicestemp= new ArrayList<UserSubService>(usersubservices);
		
		for(UserSubService usersubervice :usersubservicestemp) {
		  logg.info("  ====== "+ usersubervice   +"   "+user   +"   ");
			if(usersubervice.getUser().getUsername().equals(user.getUsername()))
				usersubservices.remove(usersubervice);
		}
		return usersubservices;

		
     }

	

	@Override
	public List<UserSubService> getSecondaries(String givercode, User giveruser) {
		
		List<UserSubService> secondaries=usersubservicerepo.findByUser(giveruser);
		
		List<UserSubService> secondariestemp= new ArrayList<UserSubService>(secondaries);
		
		for(UserSubService secondary:secondariestemp)
			if(secondary.getGivercode().equals(givercode) || secondary.getStatus()=='I')
				secondaries.remove(secondary);
				
				return secondaries;
	}

	@Override
	public List<UserSubService> findmysubservicelist(User user) {

		List<UserSubService> usersubservicelist=usersubservicerepo.findByUser(user);
		
		return usersubservicelist;
	}
	
	
	public int mySubServiceAcceptedNumber(UserSubService usersubservice) {
        //logg.info("requestservice---->"+requestservice);
			List<Request> accepted= requestservice.getMySubServiceAccepted(usersubservice);
			if(accepted != null)
			return accepted.size();
			else
				return 0;
		}
		
		public int mySubServicePendingNumber(UserSubService usersubservice) {
			List<Request> pending= requestservice.getMySubServicePending(usersubservice);
			if(pending != null)
			return pending.size();
			else
				return 0;
		}

		@Override
		public List<Request> getGiverPendingList(String givercode) {

			UserSubService giver = usersubservicerepo.findById(givercode).get();
			
			List<Request> giverpendinglist = requestservice.getMySubServicePending(giver);
			
			return giverpendinglist;
		}

		@Override
		public List<Request> getGiverAcceptedList(String givercode) {

			UserSubService giver = usersubservicerepo.findById(givercode).get();
			
			List<Request> giverpendinglist = requestservice.getMySubServiceAccepted(giver);
			
			return giverpendinglist;	
		}

		@Override
		public List<UserSubService> getActiveGivers(String subservicecode, User user) {
			List<UserSubService> usersubservices=usersubservicerepo.findByGivercodeContaining(subservicecode);
			List<UserSubService> usersubservicestemp= new ArrayList<UserSubService>(usersubservices);
			
			for(UserSubService usersubervice :usersubservicestemp) {
			  logg.info("  ====== "+ usersubervice   +"   "+user   +"   ");
				if(usersubervice.getUser().getUsername().equals(user.getUsername())  ||  usersubervice.getStatus()=='I' )
					usersubservices.remove(usersubervice);
			}
			return usersubservices;			
		}

		@Override
		public List<UserSubService> getCityActiveGivers(String subservicecode, User user,String city) {
			List<UserSubService> usersubservices=usersubservicerepo.findByGivercodeContaining(subservicecode);
			List<UserSubService> usersubservicestemp= new ArrayList<UserSubService>(usersubservices);
			
			for(UserSubService usersubservice :usersubservicestemp) {
			  //logg.info("  ====== "+ usersubservice   +"   "+user   +"   ");
				if(usersubservice.getUser().getUsername().equals(user.getUsername())  ||  usersubservice.getStatus()=='I' || !usersubservice.getCity().getName().equalsIgnoreCase(city))
					usersubservices.remove(usersubservice);
			}
			return usersubservices;		
		}

		@Override
		public List<UserSubService> getPincodeActiveGivers(String subservicecode, User user, String pincode) {
			List<UserSubService> usersubservices=usersubservicerepo.findByGivercodeContaining(subservicecode);
			List<UserSubService> usersubservicestemp= new ArrayList<UserSubService>(usersubservices);
			
			
			for(UserSubService usersubservice :usersubservicestemp) {
		if(usersubservice.getUser().getUsername().equals(user.getUsername())  ||  usersubservice.getStatus()=='I' || !usersubservice.getPincode().contains(pincode))
					{usersubservices.remove(usersubservice);
					logg.info("remove");
					}
			}
			return usersubservices;		
		}
}
