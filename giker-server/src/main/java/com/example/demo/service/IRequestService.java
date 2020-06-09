package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.RequestFormDto;
import com.example.demo.model.Request;
import com.example.demo.model.User;
import com.example.demo.model.UserSubService;

public interface IRequestService {

	void addRequest(String username, String givercode, RequestFormDto requestdto);

	List<Request> getMyPending(User username);

	List<Request> getMyDiclined(User username);

	List <Request> getMyAccepted(User user);

	List<Request> getMySubServiceAccepted(UserSubService givercode);

	List<Request> getMySubServicePending(UserSubService givercode);


	Request acceptRequest(String givercode, String username);

	Request declineRequest(String givercode, String username);

	
}
