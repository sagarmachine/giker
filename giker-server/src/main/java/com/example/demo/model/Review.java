package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="review")
public class Review {

	@Id
	@Column(name ="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="user_name")
	User username;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="giver_code")
	UserSubService givercode;
	
	@Column(name = "rating_taker")
	int ratingtaker;
	
	@Column(name = "feedback_taker")
	String feedback_taker;

	@Column(name = "rating_giver")
	int ratinggiver;
	
	@Column(name = "feedback_giver")
	String feedbackgiver;

	
	
	public Review() {}
	
	public Review(int id, int ratingtaker, String feedback_taker, int ratinggiver, String feedbackgiver) {
		super();
		this.id = id;
		this.ratingtaker = ratingtaker;
		this.feedback_taker = feedback_taker;
		this.ratinggiver = ratinggiver;
		this.feedbackgiver = feedbackgiver;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUsername() {
		return username;
	}

	public void setUsername(User username) {
		this.username = username;
	}

	public UserSubService getGivercode() {
		return givercode;
	}

	public void setGivercode(UserSubService givercode) {
		this.givercode = givercode;
	}

	public int getRatingtaker() {
		return ratingtaker;
	}

	public void setRatingtaker(int ratingtaker) {
		this.ratingtaker = ratingtaker;
	}

	public String getFeedback_taker() {
		return feedback_taker;
	}

	public void setFeedback_taker(String feedback_taker) {
		this.feedback_taker = feedback_taker;
	}

	public int getRatinggiver() {
		return ratinggiver;
	}

	public void setRatinggiver(int ratinggiver) {
		this.ratinggiver = ratinggiver;
	}

	public String getFeedbackgiver() {
		return feedbackgiver;
	}

	public void setFeedbackgiver(String feedbackgiver) {
		this.feedbackgiver = feedbackgiver;
	}

	

	
	

	
	
	
	
	
	
}
