package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CoachRepository;
import com.example.demo.dao.RequestRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dao.UserSubServiceRepository;
import com.example.demo.dto.RequestFormDto;
import com.example.demo.model.Request;
import com.example.demo.model.Review;
import com.example.demo.model.User;
import com.example.demo.model.UserSubService;


@Service

public class RequestServiceImp implements IRequestService {

	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	RequestRepository requestrepo;
	
	@Autowired
	UserSubServiceRepository usersubservicerepo;
	
	Logger logg= Logger.getLogger(RequestServiceImp.class);
	
	
	@Override
	public void addRequest(String username, String givercode, RequestFormDto requestdto) {

		logg.info("111111111");
		
		User user=userrepo.findById(username).get();
		
		
		logg.info("2222222222 giver code"+givercode);
		UserSubService usersubservice=usersubservicerepo.findById(givercode).get();
		
		
		logg.info("3333333333333");
		Request request=null;
		
		String requestcode=username+"_"+givercode;
		
		try{
			request = requestrepo.findById(requestcode).get();
			if(request !=null)
				requestrepo.delete(request);
		}catch(Exception ex) {
			
			logg.info("EXCEPTION-=-=-=--=>"+ex);
		}
		
		
		logg.info("444444444444444 ");
		if(request==null)
		{	
			logg.info("555555555555");
			request = new Request();
			request.setCode(requestcode);
		}
		
		//logg.info("6666666666666  request   --"+request);
		
		request.setDate(new Date());
		request.setAcceptdate(null);
		logg.info("77777777777777");
		request.setMessage1(requestdto.getMessage());
		
		logg.info("88888888888888");
         request.setMessage2(String.join("_",requestdto.getDetailstoshare()));
        request.setRequeststatus('P');
         request.setReviewstatusgiver('N');
          request.setReviewstatustaker('N');          
         logg.info("999999999999999");
		user.addRequest(request);
		
		logg.info("aaaaaaaaaaaa");
		usersubservice.addRequest(request);
		
		logg.info("bbbbbbbb");
		userrepo.save(user);
		
		logg.info("ccccccccc");
		usersubservicerepo.save(usersubservice);
		
	}

	@Override
	public List<Request> getMyAccepted(User username) {

		List<Request> accepted = requestrepo.findAccepted(username);
		
		return accepted;
	}

	@Override
	public List<Request> getMyPending(User username) {
		List<Request> pending = requestrepo.findPending(username);
		return pending;
	}

	@Override
	public List<Request> getMyDiclined(User username) {
		List<Request> declined = requestrepo.findDiclined(username);
		return declined;
	}

	public List<Request> getMySubServiceAccepted(UserSubService givercode) {

		List <Request> mysubserviceaccepted= requestrepo.findSubServiceAccepted(givercode);
		
		
		return mysubserviceaccepted;
	}
	
	public List<Request> getMySubServicePending(UserSubService givercode) {

		List <Request> mysubservicepending= requestrepo.findSubServicePending(givercode);
		
		
		return mysubservicepending;
	}



	@Override
	public Request acceptRequest(String givercode, String username) {
		
		String requestcode= username+"_"+givercode ;
		
		Request request = requestrepo.findById(requestcode).get();
		
		request.setAcceptdate(new Date());
		
		request.setRequeststatus('A');
		
	
		requestrepo.save(request);
		//MAIL THE DETAILS !!!!!
		
		
				return null;
	}

	@Override
	public Request declineRequest(String givercode, String username) {

	String requestcode= username+"_"+givercode ;
		
		Request request = requestrepo.findById(requestcode).get();
     request.setAcceptdate(new Date());
		
		request.setRequeststatus('D');
		requestrepo.save(request);
		return null;
	}

	
	
	
}
