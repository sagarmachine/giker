package com.example.demo.service;

import com.example.demo.dto.ReviewDto;
import com.example.demo.model.Review;
import com.example.demo.model.User;
import com.example.demo.model.UserSubService;

public interface IReviewService {

	void addGiverFeedback(User user, UserSubService usersubservice, ReviewDto reviewdto);

	void addTakerFeedback(User user, UserSubService usersubservice, ReviewDto reviewdto);

	
	Review getReview(User user, UserSubService usersubservice);


         int getTotalRating(User user);
	
	int[] getSubServiceRating(UserSubService givercode);
}
