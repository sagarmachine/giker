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

@Table(name="education")
public class Education implements Serializable {

	
	//Column Fields------------------------>
	@Id
	String id;
	
	
	@OneToOne
	@MapsId
	@JoinColumn(name="giver_code")
	UserSubService givercode;
		
		@Column(name="hometution")
		String hometution;
		
		 @Column(name = "grade")
		String grade;

        public Education() {}
        
		

		public Education(String hometution, String grade) {
			super();
			this.hometution = hometution;
			this.grade = grade;
		}



		public UserSubService getGivercode() {
			return givercode;
		}

		public void setGivercode(UserSubService givercode) {
			this.givercode = givercode;
		}

		
		public String getHometution() {
			return hometution;
		}

		public void setHometution(String hometution) {
			this.hometution = hometution;
		}

		
		public String getGrade() {
			return grade;
		}

		public void setGrade(String grade) {
			this.grade = grade;
		}



		@Override
		public String toString() {
			return "Education [givercode=" + givercode.getGivercode() + ", hometution=" + hometution + ", grade=" + grade + "]";
		}

		
        
        
        
		
}
