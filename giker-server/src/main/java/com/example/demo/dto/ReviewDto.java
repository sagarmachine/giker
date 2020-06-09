package com.example.demo.dto;

public class ReviewDto {
	
	String feedback;
	
	int ratings=4;
	public ReviewDto() {}
	
	
	public ReviewDto(String feedback, int ratings) {
		super();
		this.feedback = feedback;
		this.ratings = ratings;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	
	
}
