package com.example.demo.model.ecommerce;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.example.demo.model.UserSubService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

;

@Entity
@Table(name = "seller")
@JsonIgnoreProperties(value = {"givercode"})
public class Seller implements Serializable {

//Column Fields----------------------------------------------------------------------------
	@Id
	String id;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "giver_code")
	UserSubService givercode;

	

	@Column(name = "shop_name")
	private String shopname;

	@Column(name = "shop_address")
	private String shopaddress;

	@Column(name = "secondary_phone")
	private String secondaryphone;

	@Column(name = "home_delivery")
	private char homedelivery;
	
	@Column(name = "shop_image")
	private byte[] shopimage;
	
	@Transient
	int totalorder;
	
	@Transient
	int totalrating;
	
	@Transient
	int averagerating;
	
	@Transient
	 private Date datejoined;
	
	@Transient
	private String sellername;
	
	@Transient
	private String primaryphone;

//CONSTRUCTORS----------------------------------------------------------------------------

	
	public String getSellername() {
		return sellername;
	}
	public void setSellername(String sellername) {
		this.sellername = sellername;
	}
	public String getPrimaryphone() {
		return primaryphone;
	}
	public void setPrimaryphone(String primaryphone) {
		this.primaryphone = primaryphone;
	}
	public Seller() {
	}
	public Seller(String shopname, String shopaddress, String secondaryphone, char homedelivery, byte[] shopimage) {
		super();
		this.shopname = shopname;
		this.shopaddress = shopaddress;
		this.secondaryphone = secondaryphone;
		this.homedelivery = homedelivery;
		this.shopimage = shopimage;
	}
   
	
	
	
//Column Fields -Getters and Setters----------------------------------------------------------------------------

	public Date getDatejoined() {
		return datejoined;
	}
	public void setDatejoined(Date datejoined) {
		this.datejoined = datejoined;
	}
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
			
	public UserSubService getGivercode() {
		return givercode;
	}

	public int getTotalorder() {
		return totalorder;
	}

	public void setTotalorder(int totalorder) {
		this.totalorder = totalorder;
	}

	public int getTotalrating() {
		return totalrating;
	}

	public void setTotalrating(int totalrating) {
		this.totalrating = totalrating;
	}

	public int getAveragerating() {
		return averagerating;
	}

	public void setAveragerating(int averagerating) {
		this.averagerating = averagerating;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonIgnore
	public Set<ProductSeller> getSellerproducts() {
		return sellerproducts;
	}

	@JsonIgnore
	public void setSellerproducts(Set<ProductSeller> sellerproducts) {
		this.sellerproducts = sellerproducts;
	}
   
	public void setGivercode(UserSubService givercode) {
		this.givercode = givercode;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getShopaddress() {
		return shopaddress;
	}

	public void setShopaddress(String shopaddress) {
		this.shopaddress = shopaddress;
	}

	public String getSecondaryphone() {
		return secondaryphone;
	}

	public void setSecondaryphone(String secondaryphone) {
		this.secondaryphone = secondaryphone;
	}

	public char getHomedelivery() {
		return homedelivery;
	}

	public void setHomedelivery(char homedelivery) {
		this.homedelivery = homedelivery;
	}

	public byte[] getShopimage() {
		return shopimage;
	}

	public void setShopimage(byte[] shopimage) {
		this.shopimage = shopimage;
	}

//ToString method----------------------------------------------------------------------------

	@Override
	public String toString() {
		return "Seller [givercode=" + givercode + ", shopname=" + shopname + ", shopaddress=" + shopaddress
				+ ", secondaryphone=" + secondaryphone + ", homedelivery=" + homedelivery + ", shopimage="
				+ Arrays.toString(shopimage) + "]";
	}

////Relational Fields
	@OneToMany(mappedBy = "givercode", cascade = { CascadeType.ALL })
	private Set<Order> orders;
	public void addCartitem(Order order) {

		if (orders == null) {
			orders = new HashSet<Order>();
		}
		orders.add(order);

	 order.setGivercode(this);

	}
	
	@OneToMany(mappedBy = "seller", fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.REMOVE })
	Set<ProductSeller> sellerproducts;

	public void addSellerProduct(ProductSeller p) {

		if (sellerproducts == null) {
			sellerproducts = new HashSet<ProductSeller>();
		}
		sellerproducts.add(p);

		p.setSeller(this);
	}

}