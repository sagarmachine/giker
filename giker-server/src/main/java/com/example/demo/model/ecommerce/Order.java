package com.example.demo.model.ecommerce;

import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.example.demo.model.User;
import com.example.demo.model.UserAddress;
import com.example.demo.model.UserPhone;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "oorder")
@JsonIgnoreProperties(value = {"username","givercode","deliveryaddressid","contactno",})
public class Order {

	// Column
	// Fields----------------------------------------------------------------------------
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;

	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name = "user_id") 
	private User username;

	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name = "giver_code")
	private Seller givercode;

	
	@Column(name = "date")
	private Date date;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "datee")
	private Date datee;

	
	@Column(name = "status")
	private char status;

	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name = "delivery_address_id")
	private UserAddress deliveryaddressid;

	@ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name = "contact_no")
	private UserPhone contactno;

	@Column(name = "total_price")
	private Double totalprice;
	

	@Column(name="mode")
	private String mode;

	
	@Transient
	private int totalitems;
	

	@Transient
	private String sellername;
	
	@Transient
	private String sellerphone;
	
	@Transient
	private String customername;
	
	@Transient
	private String customerphone;
	
	
	
	// CONSTRUCTORS----------------------------------------------------------------------------

	public Order() {
	}

	public Order( Date date,Date datee, char status, UserAddress deliveryaddressid,
			UserPhone contactno, Double totalprice,String mode) {

		this.date = date;
		this.datee = datee;
		this.status = status;
		this.deliveryaddressid = deliveryaddressid;
		this.contactno = contactno;
		this.totalprice = totalprice;
		this.mode=mode;

	}

	public Order(int orderid, User username, Seller givercode, Date date, char status, UserPhone contactno,
			Double totalprice) {
		super();
		this.orderid = orderid;
		this.username = username;
		this.givercode = givercode;
		this.date = date;
		this.status = status;
		this.contactno = contactno;
		this.totalprice = totalprice;
	}




	// Column Fields -Getters and
	// Setters----------------------------------------------------------------------------
	
	public Date getDatee() {
		return datee;
	}

	public void setDatee(Date datee) {
		this.datee = datee;
	}

	public int getTotalitems() {
		return totalitems;
	}

	public void setTotalitems(int totalitems) {
		this.totalitems = totalitems;
	}
	
	public int getOrderid() {
		return orderid;
	}

	public String getSellername() {
		return sellername;
	}

	public void setSellername(String sellername) {
		this.sellername = sellername;
	}

	public String getSellerphone() {
		return sellerphone;
	}

	public void setSellerphone(String sellerphone) {
		this.sellerphone = sellerphone;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public User getUsername() {
		return username;
	}

	public void setUsername(User username) {
		this.username = username;
	}

	public Seller getGivercode() {
		return givercode;
	}

	public void setGivercode(Seller givercode) {
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

	public UserAddress getDeliveryaddressid() {
		return deliveryaddressid;
	}

	public void setDeliveryaddressid(UserAddress deliveryaddressid) {
		this.deliveryaddressid = deliveryaddressid;
	}

	public UserPhone getContactno() {
		return contactno;
	}

	public void setContactno(UserPhone contactno) {
		this.contactno = contactno;
	}

	public Double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}
	
	public String getCustomername() {
		return customername;
	}

	public void setCustomername(User user) {
		this.customername = user.getFirstname()+" "+user.getLastname();
	}

	public String getCustomerphone() {
		return customerphone;
	}

	public void setCustomerphone(UserPhone phone) {
		this.customerphone = phone.getPhone();
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}
	
	
	

	// ToString
	// method----------------------------------------------------------------------------

	
	
	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", username=" + username.getFirstname() + ", givercode=" + givercode.getShopname() + ", date=" + date
				+ ", status=" + status + ", deliveryaddressid=" + deliveryaddressid + ", contactno=" + contactno
				+ ", totalprice=" + totalprice + "]";
	}
	
	//Relational Fields--------------------
	//One to many with orderiems
	
	
	@OneToMany(mappedBy = "orderid", cascade = { CascadeType.ALL })
	private Set<OrderItem> orderitems;
	

	public Set<OrderItem> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(Set<OrderItem> orderitems) {
		this.orderitems = orderitems;
	}
	

	
	public void addOrderitem(OrderItem item) {

		if (orderitems == null) {
			orderitems = new HashSet<OrderItem>();
		}
		orderitems.add(item);

		item.setOrderid(this);

	}

}
