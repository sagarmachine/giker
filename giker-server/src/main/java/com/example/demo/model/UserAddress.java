package com.example.demo.model;

import java.util.Arrays;
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
import javax.persistence.Transient;

import com.example.demo.model.ecommerce.Order;


@Entity
@Table(name="user_address")
public class UserAddress {
	
//////////Fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name = "user_name")
	private User userid;
	
	@Column(name="house_no")
	private String houseno;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="pin_code")
	private String pincode;
	
	@Column(name="country")
	private String country;
	
	@Transient
	private String[] address;
	
//////////////Constructors----

	public UserAddress() {}
	public UserAddress(User userid, String houseno, String city, String state, String pincode, String country,
			String[] address) {
		super();
		this.userid = userid;
		this.houseno = houseno;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.country = country;
		this.address = address;
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
	public String getHouseno() {
		return houseno;
	}
	public void setHouseno(String houseno) {
		this.houseno = houseno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String[] getAddress() {
		return address;
	}
	public void setAddress(String[] address) {
		this.address = address;
	}
	
////////////----Tostring
	
	@Override
	public String toString() {
		return "UserAddress [id=" + id + ", userid=" + userid + ", houseno=" + houseno + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + ", country=" + country + ", address=" + Arrays.toString(address)
				+ "]";
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
