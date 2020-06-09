package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "coach")
public class Coach implements Serializable {
//Column Fields------------------------>
	@Id
	String id;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name="giver_code")
	UserSubService givercode;

	
	
	
	public Coach() {}
	
	public UserSubService getGivercode() {
		return givercode;
	}

	public void setGivercode(UserSubService givercode) {
		this.givercode = givercode;
	}

	@Override
	public String toString() {
		return "Coach [givercode=" + givercode.getGivercode() + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
