package com.example.demo.model;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.tomcat.util.codec.binary.Base64;

import com.example.demo.model.ecommerce.Cart;
import com.example.demo.model.ecommerce.Order;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")

public class User {

//Column Fields----------------------------------------------------------------------------

	@Id
	@Column(name = "user_name")
	private String username;

	@Column(name = "first_name")
	private String firstname;

	@Column(name = "last_name")
	private String lastname;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "phone")
	private String phone;

	@Column(name = "gender")
	private char gender;

	
	@Column(name = "image")
	private byte[] image;

	@Column(name = "instagram")
	private String instagram;

	@Column(name = "public_info")
	private String publicinfo = "age_instagram";
//CONSTRUCTORS----------------------------------------------------------------------------

	public User() {

	}

	public User(String username, String firstname, String lastname, Date dob, String email, String password,
			String phone, char gender, byte[] image, String instagram, String publicinfo) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.gender = gender;
		this.image = image;
		this.instagram = instagram;
		this.publicinfo = publicinfo;
	}

	public User(String username, String firstname, String lastname, Date dob, String email, String password,
			String phone, char gender, byte[] image, String publicinfo) {
		super();
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.gender = gender;
		this.image = image;
		this.publicinfo = publicinfo;
	}

	public User(String username, String firstname, String lastname, Date dob, String email, String password,
			String phone, char gender, byte[] image) {

		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.gender = gender;
		this.image = image;
	}

// Column Fields -Getters and Setters----------------------------------------------------------------------------

	public String getUsername() {
		return username;
	}

	public String getPublicinfo() {
		return publicinfo;
	}

	public void setPublicinfo(String publicinfo) {
		this.publicinfo = publicinfo;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

//age util-------------------->

	@Transient
	int age;

	@SuppressWarnings("deprecation")
	public int getAge() {

		Date today = new Date();
		if (dob != null)
			age = today.getYear() - dob.getYear();

		return age;
	}

	// image util --------------------------------->
	@Transient
	String profilepic;

	public String getProfilepic() throws UnsupportedEncodingException {

		byte[] encodeBase64 = Base64.encodeBase64(image);
		String base64Encoded = new String(encodeBase64, "UTF-8");
		return base64Encoded;
	}

// Relational Fields---------------------------------------------->

	
	@OneToOne(mappedBy = "username", cascade = CascadeType.ALL)
	private Cart cart;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
//----------------------
	@OneToMany(mappedBy = "username", cascade = { CascadeType.ALL })
	private Set<Order> orders;

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	

	public void addCartitem(Order order) {

		if (orders == null) {
			orders = new HashSet<Order>();
		}
		orders.add(order);

		order.setUsername(this);

	}

	
	
	// Many to Many with Role----->
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_name"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;

	public List<Role> getRoles() {
		return roles;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob
				+ ", email=" + email + ", password=" + password + ", phone=" + phone + ", gender=" + gender + ", image="
				+ image + ", roles=" + roles + ", getUsername()=" + getUsername() + ", getFirstname()=" + getFirstname()
				+ ", getLastname()=" + getLastname() + ", getDob()=" + getDob() + ", getEmail()=" + getEmail()
				+ ", getPassword()=" + getPassword() + ", getPhone()=" + getPhone() + ", getGender()=" + getGender()
				+ ", getImage()=" + getImage() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void addRole(Role role) {
		if (roles == null)
			roles = new ArrayList();
		roles.add(role);
		role.addUser(this);
//	}
	}
	// One To Many with UserSubService--------->

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	List<UserSubService> usersubservices;

//	public List<UserSubService> getUsersubservices() {
//		return usersubservices;
//	}

	public void setUsersubservices(List<UserSubService> usersubservices) {
		this.usersubservices = usersubservices;
	}

	public void addUserSubService(UserSubService usersubservice) {

		if (usersubservices == null)
			usersubservices = new ArrayList();
		usersubservices.add(usersubservice);
		usersubservice.setUser(this);
	}

//Request Relation----------------------------->

	@OneToMany(mappedBy = "username", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.REMOVE }, fetch = FetchType.LAZY)
	List<Request> requests;

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public void addRequest(Request request) {

		if (requests == null)
			requests = new ArrayList<Request>();
		requests.add(request);
		request.setUsername(this);
	}

//Review Relation	
	@OneToMany(mappedBy = "username", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH, CascadeType.REMOVE }, fetch = FetchType.LAZY)
	List<Review> reviews;

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public void addReview(Review review) {

		if (reviews == null)
			reviews = new ArrayList<Review>();
		reviews.add(review);
		review.setUsername(this);
	}
	
//USER PHONE RELATION	
	@OneToMany(mappedBy = "userid", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH, CascadeType.REMOVE }, fetch = FetchType.LAZY)
	List<UserPhone> userphones;
	
	
	
public List<UserPhone> getUserphones() {
		return userphones;
	}

	public void setUserphones(List<UserPhone> userphones) {
		this.userphones = userphones;
	}
	
public void addUserPhone(UserPhone phone) {
	if(userphones==null) userphones= new ArrayList<UserPhone>();
	
	userphones.add(phone);
	
	phone.setUserid(this);
	
	
}

	

	//USER ADDRESS RELATION 	
	@OneToMany(mappedBy = "userid", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH, CascadeType.REMOVE }, fetch = FetchType.LAZY)
	List<UserAddress> useraddresses;
	public List<UserAddress> getUseraddresses() {
		return useraddresses;
	}

	public void setUseraddresses(List<UserAddress> useraddresses) {
		this.useraddresses = useraddresses;
	}
	
	public void addUserAddress(UserAddress address) {
		
		if(useraddresses==null) useraddresses= new ArrayList<UserAddress>();
		
		useraddresses.add(address);
		
		address.setUserid(this);
	}

}
