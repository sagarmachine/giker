package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
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

import com.example.demo.model.ecommerce.Order;


@Entity
@Table(name="user_phone")
public class UserPhone {
	

//////////Fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name = "user_id")
	private User userid;
	
	@Column(name="phone")
	private String phone;
	
//////////////Constructors----
	public UserPhone() {}

	public UserPhone( String phone) {
		this.phone = phone;
	}

	
	
	
///////Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	/////////////---------ToString
	
	@Override
	public String toString() {
		return "UserPhone [id=" + id + ", userid=" + userid + ", phone=" + phone + "]";
	}
	
	////Relational Fields
	@OneToMany(mappedBy = "username", cascade = { CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST })
	private Set<Order> orders;

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	
	

	

}
