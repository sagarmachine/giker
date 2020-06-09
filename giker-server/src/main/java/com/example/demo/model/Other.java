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
@Table(name ="other_sub_service" )
public class Other implements Serializable {

	//Column Fields------------------------>
	@Id
	String id;
	
	
	@OneToOne
	@MapsId
	@JoinColumn(name="giver_code")
	UserSubService givercode;
		
		@Column(name="keyword")
		String keyword;

		public Other() {};
		
	

		public Other(String keyword) {
			super();
			this.keyword = keyword;
		}



		public UserSubService getGivercode() {
			return givercode;
		}

		public void setGivercode(UserSubService givercode) {
			this.givercode = givercode;
		}

	

		public String getKeyword() {
			return keyword;
		}

		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}



		@Override
		public String toString() {
			return "Other [givercode=" + givercode.getGivercode() + ", keyword=" + keyword + "]";
		}

		
		
		
		
		
		
}
