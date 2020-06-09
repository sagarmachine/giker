package com.example.demo.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RequestRepository;
import com.example.demo.dao.ReviewRepository;
import com.example.demo.dao.UserSubServiceRepository;
import com.example.demo.dto.ReviewDto;
import com.example.demo.model.Request;
import com.example.demo.model.Review;
import com.example.demo.model.User;
import com.example.demo.model.UserSubService;

@Service
public class ReviewServiceImp implements IReviewService {

	@Autowired
	RequestRepository requestrepo;
	
	
	@Autowired
	UserSubServiceRepository usersubservicerepo;
	
	@Autowired
	ReviewRepository reviewrepo;
	
	Logger logg= Logger.getLogger(RequestServiceImp.class);
	@Override
	public void addGiverFeedback(User user, UserSubService usersubservice, ReviewDto reviewdto) {

		//logg.info("--------->"+user.getUsername()+"======"+usersubservice.getSubservice().getCode());
		

		Review review = reviewrepo.findByUsernameAndGivercode(user,usersubservice);
		Request request = requestrepo.findById(user.getUsername()+"_"+usersubservice.getGivercode()).get();
		
		if(review==null)
			review=new Review();
		else
			//reviewrepo.delete(review);
			logg.info("--------->======"+reviewdto.getFeedback());
		review.setFeedbackgiver(reviewdto.getFeedback());
		review.setRatinggiver(reviewdto.getRatings());
		
		request.setReviewstatusgiver('Y');
          user.addReview(review);
          usersubservice.addReview(review);
		requestrepo.save(request);
		reviewrepo.save(review);
		
	}
	@Override
	public void addTakerFeedback(User user, UserSubService usersubservice, ReviewDto reviewdto) {

		Review review = reviewrepo.findByUsernameAndGivercode(user,usersubservice);
		Request request = requestrepo.findById(user.getUsername()+"_"+usersubservice.getGivercode()).get();
		
		if(review==null)
			review=new Review();
//		else
//			reviewrepo.delete(review);
		
		review.setFeedback_taker(reviewdto.getFeedback());
		review.setRatingtaker(reviewdto.getRatings());
		
		request.setReviewstatustaker('Y');
          user.addReview(review);
          usersubservice.addReview(review);
		requestrepo.save(request);
		reviewrepo.save(review);		
	}
	@Override
	public Review getReview(User user, UserSubService usersubservice) {

		return reviewrepo.findByUsernameAndGivercode(user, usersubservice);
	}
	@Override
	public int getTotalRating(User user) {

		logg.info("------------------->"+user.getUsername()+"-=-=-=-=-=-"+usersubservicerepo);
		
		Integer counttaker = reviewrepo.getTakerCount(user);
		Integer sumtaker =reviewrepo.getTakerSum(user);
		
		if(sumtaker == null)
			{counttaker=0;
			 sumtaker=0;
			}
		
		logg.info("counttaker--"+counttaker+" -=-=-=-=-sumtaker-----"+sumtaker);
		
		List<UserSubService> usersubservices =  usersubservicerepo.findByGivercodeContaining(user.getUsername()+"_");
		
		Integer countgiver=0;
		Integer sumgiver=0;

		
		for(UserSubService givercode:usersubservices)
		{
		Integer countgivertemp=reviewrepo.getGiverCount(givercode);
			Integer sumgivertemp=reviewrepo.getGiverSum(givercode);
			logg.info("countgivertemp--"+countgivertemp+" -=-=-=-=-sumgivertemp-----"+sumgivertemp);

			if(countgivertemp !=null &&  sumgivertemp !=null) {
				countgiver+=countgivertemp;
				sumgiver+=sumgivertemp;
				
			}
				
			
		}
		
	double totalcount=countgiver+counttaker;
		int totalsum= sumgiver+sumtaker;
		
		if(totalsum == 0)
			return 5;
		
		return  (int)Math.ceil(totalsum/totalcount);
	}
	@Override
	public int[] getSubServiceRating(UserSubService givercode) {
		Integer countgiver=reviewrepo.getGiverCount(givercode);
		Integer sumgiver=reviewrepo.getGiverSum(givercode);
		
		if(sumgiver== null)
			return new int[]{5,0};
		
		logg.info("stars----"+(int)Math.ceil((double)sumgiver/countgiver)+"-----count-->"+countgiver);
		
		return  new int[] {(int)Math.ceil((double)sumgiver/countgiver),countgiver};
	}
	

	
}
