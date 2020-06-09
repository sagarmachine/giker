package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tutor")
public class Tutor implements Serializable{

	//Column Fields------------------------>
	@Id
	String id;
	
	
	@OneToOne
	@MapsId
	@JoinColumn(name="giver_code")
	UserSubService givercode;
			
			@Column(name="own_place")
			String ownplace;
			
			@Column(name="own_tools")
			String owntools;
			
			
public Tutor() {}


			
			public Tutor(String ownplace, String tools) {
	super();
	this.ownplace = ownplace;
	this.owntools = tools;
}



			public UserSubService getGivercode() {
				return givercode;
			}

			public void setGivercode(UserSubService givercode) {
				this.givercode = givercode;
			}

		
			public String getOwnplace() {
				return ownplace;
			}

			public void setOwnplace(String ownplace) {
				this.ownplace = ownplace;
			}

			public String getOwntools() {
				return owntools;
			}

			public void setOwntools(String tools) {
				this.owntools = tools;
			}

			@Override
			public String toString() {
				return "Tutor [givercode=" + givercode.getGivercode() + ", ownplace=" + ownplace + ", tools=" + owntools + "]";
			}

			

			
			
			
}
