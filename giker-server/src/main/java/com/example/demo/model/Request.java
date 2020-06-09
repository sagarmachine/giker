package com.example.demo.model;

import java.util.Date;

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
@Table(name = "request")
public class Request {

	@Id
	@Column(name = "code")
	String code;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="user_name")
	User username;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="giver_code")
	UserSubService givercode;
	
	
    @Column(name = "request_status")
    char requeststatus;
    
    @Column(name = "review_status_taker")
    char reviewstatustaker;
    
    @Column(name = "review_status_giver")
    char reviewstatusgiver;
    
    @Column(name="date")
    Date date;
    
    @Column(name = "message1")
    String message1;
    
    @Column(name = "message2")
    String message2;

    
    @Column(name="accept_date")
    Date acceptdate;
    
    public Request() {}
    
    
    
	public Request(String code, char requeststatus, char reviewstatus, Date date, String message1, String message2) {
		super();
		this.code = code;
		this.requeststatus = requeststatus;
		this.reviewstatustaker = reviewstatus;
		this.date = date;
		this.message1 = message1;
		this.message2 = message2;
	}



	public Request(char requeststatus, char reviewstatus, Date date, String message1, String message2) {
		super();
		this.requeststatus = requeststatus;
		this.reviewstatustaker = reviewstatus;
		this.date = date;
		this.message1 = message1;
		this.message2 = message2;
	}

	
	
	
	public Request(String code, char requeststatus, char reviewstatustaker, char reviewstatusgiver, Date date,
			String message1, String message2) {
		super();
		this.code = code;
		this.requeststatus = requeststatus;
		this.reviewstatustaker = reviewstatustaker;
		this.reviewstatusgiver = reviewstatusgiver;
		this.date = date;
		this.message1 = message1;
		this.message2 = message2;
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public char getRequeststatus() {
		return requeststatus;
	}

	public void setRequeststatus(char requeststatus) {
		this.requeststatus = requeststatus;
	}

	

	public Date getAcceptdate() {
		return acceptdate;
	}



	public void setAcceptdate(Date acceptdate) {
		this.acceptdate = acceptdate;
	}



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage1() {
		return message1;
	}

	public void setMessage1(String message1) {
		this.message1 = message1;
	}

	public String getMessage2() {
		return message2;
	}

	public void setMessage2(String message2) {
		this.message2 = message2;
	}

	
	
	
	
	
	public char getReviewstatustaker() {
		return reviewstatustaker;
	}



	public void setReviewstatustaker(char reviewstatustaker) {
		this.reviewstatustaker = reviewstatustaker;
	}



	public char getReviewstatusgiver() {
		return reviewstatusgiver;
	}



	public void setReviewstatusgiver(char reviewstatusgiver) {
		this.reviewstatusgiver = reviewstatusgiver;
	}



	@Override
	public String toString() {
		return "Request [code=" + code + ", username=" + username.getUsername() + ", givercode=" + givercode.getGivercode() + ", requeststatus="
				+ requeststatus + ", reviewstatus=" + reviewstatustaker + ", date=" + date + ", message1=" + message1
				+ ", message2=" + message2 + "]";
	}





}


