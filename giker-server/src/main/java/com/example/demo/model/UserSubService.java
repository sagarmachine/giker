package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Persistable;
import org.springframework.stereotype.Component;

import com.example.demo.model.ecommerce.Seller;
import com.example.demo.service.IRequestService;
import com.example.demo.service.RequestServiceImp;
import com.example.demo.service.UserSubServiceImp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;






@Component
@Entity
@Table(name = "user_sub_service")

public  class UserSubService{

	@Transient
	Logger logg = Logger.getLogger(UserSubService.class);
	
	

	@Id
	@Column(name = "giver_code")
	String givercode;
	
	@Column(name="date")
	Date date;
	
	@Column(name="status")
	char status;
	
	@ManyToOne(fetch=FetchType.LAZY )
	@JoinColumn(name = "user_name")
	User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sub_service_code")
	SubService subservice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	City city;

	@Column(name="location")
	String location;
	
	@Column(name = "description")
	String description;
	
	@Column(name = "achievement")
	String achievements;
	
	@Column(name="experience")
	String experience;
	
	@Column(name ="instagram")
	String instagram;
	
	@Column(name ="pincode")
	String pincode;
	
	public UserSubService() {}
	
	public UserSubService(String name, Date date, char status) {
		this.givercode = name;
		this.date = date;
		this.status = status;
	}

	public UserSubService(String name, Date date, char status, User username, SubService subservicecode, City city) {
		this.givercode = name;
		this.date = date;
		this.status = status;
		this.user = username;
		this.subservice = subservicecode;
		this.city = city;
	}

	
	
	public UserSubService(Date date, char status, City city, String location, String description, String achievements,
			String experirence, String instagram,String pincode) {
		this.date = date;
		this.status = status;
		this.city = city;
		this.location = location;
		this.description = description;
		this.achievements = achievements;
		this.experience = experirence;
		this.instagram = instagram;
		this.pincode=pincode;
	}

	public String getGivercode() {
		return givercode;
	}

	public void setGivercode(String givercode) {
		this.givercode = givercode;
	}
	
public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User username) {
		this.user = username;
	}

	public SubService getSubservice() {
		return subservice;
	}

	public void setSubservice(SubService subservicecode) {
		this.subservice = subservicecode;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAchievements() {
		return achievements;
	}

	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experirence) {
		this.experience = experirence;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	
	
	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	

	@Override
	public String toString() {
		return "UserSubService [givercode=" + givercode + ", date=" + date + ", status=" + status + ", user=" + user.getUsername()
				+ ", subservice=" + subservice.getCode() + ", city=" + city + ", location=" + location + ", description="
				+ description + ", achievements=" + achievements + ", experirence=" + experience + ", instagram="
				+ instagram + ", pincode=" + pincode + ", coach=" + coach + ", education=" + education + "]";
	}



//Coach Relation----------------------------------------->
	@OneToOne(mappedBy="givercode",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	 Coach coach;

	
	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
		coach.setGivercode(this);
	}
	
	
	
//Education  Relation----------------------------------------->
		@OneToOne(mappedBy="givercode",cascade = CascadeType.ALL)
		 Education education;

		
		public Education getEducation() {
			return education;
		}

		public void setEducation(Education education) {
			this.education = education;
			education.setGivercode(this);
		}

		
//Tutor  Relation----------------------------------------->
				@OneToOne(mappedBy="givercode",cascade = CascadeType.ALL)
				 Tutor tutor;
			
				public Tutor getTutor() {
					return tutor;
				}

				public void setTutor(Tutor tutor) {
					this.tutor = tutor;
					tutor.setGivercode(this);
				}

				
//Other Relation
			@OneToOne(mappedBy = "givercode",cascade = CascadeType.ALL)
			Other other;
			
			public Other getOther() {
				return other;
			}

			public void setOther(Other other) {
				this.other = other;
				other.setGivercode(this);
			}
			
			
//Seller Relation
			@OneToOne(mappedBy = "givercode",cascade = CascadeType.ALL)
			Seller seller;
			
			
			public Seller getSeller() {
				return seller;
			}

			public void setSeller(Seller seller) {
				this.seller = seller;
				seller.setGivercode(this);
			}
			
		
//Request Relation----------------------------->
		
		
	



	@OneToMany(mappedBy ="givercode",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE} ,fetch = FetchType.LAZY)
		List<Request> requests;

		public List<Request> getRequests() {
			return requests;
		}

		public void setRequests(List<Request> requests) {
			this.requests = requests;
		}
		
		public void addRequest(Request request) {
			
			if(requests==null)
				requests= new ArrayList<Request>();
			requests.add(request);
			request.setGivercode(this);
		}
		 
		
//Review Relation	
		@OneToMany(mappedBy ="givercode",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
		List<Review> reviews;

		
		
		public List<Review> getReviews() {
			return reviews;
		}

		public void setReviews(List<Review> reviews) {
			this.reviews = reviews;
		}

		public void addReview(Review review) {
			
			if(reviews==null)
				reviews= new ArrayList<Review>();
			reviews.add(review);
			review.setGivercode(this);
		}
		 //-----------------------------------=====
	

		
		
		
		
		
		
		
}
