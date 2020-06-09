package com.example.demo.model.ecommerce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_review")
public class OrderReview  {

	// Column
	// Fields----------------------------------------------------------------------------

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewid;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private Order orderid;
	
	

	@Column(name = "customer_rating")
	int customerrating;

	@Column(name = "seller_rating")
	int sellerrating;

	@Column(name = "customer_feedback")
	String customerfeedback;

	@Column(name = "seller_feedback")
	String sellerfeedback;

	// CONSTRUCTORS----------------------------------------------------------------------------

	public OrderReview() {
	}

	public OrderReview(Order orderid, int customerrating, int sellerrating, String customerfeedback,
			String sellerfeedback) {
		super();
		this.orderid = orderid;
		this.customerrating = customerrating;
		this.sellerrating = sellerrating;
		this.customerfeedback = customerfeedback;
		this.sellerfeedback = sellerfeedback;
	}

	public OrderReview(int customerrating, String customerfeedback) {
		super();
		this.customerrating = customerrating;
		this.customerfeedback = customerfeedback;
	}

	public OrderReview(String sellerfeedback, int sellerrating) {
		super();
		this.sellerrating = sellerrating;
		this.sellerfeedback = sellerfeedback;
	}

	// Column Fields -Getters and
	// Setters----------------------------------------------------------------------------

	public Order getOrderid() {
		return orderid;
	}

	public void setOrderid(Order orderid) {
		this.orderid = orderid;
	}

	public int getCustomerrating() {
		return customerrating;
	}

	public void setCustomerrating(int customerrating) {
		this.customerrating = customerrating;
	}

	public int getSellerrating() {
		return sellerrating;
	}

	public void setSellerrating(int sellerrating) {
		this.sellerrating = sellerrating;
	}

	public String getCustomerfeedback() {
		return customerfeedback;
	}

	public void setCustomerfeedback(String customerfeedback) {
		this.customerfeedback = customerfeedback;
	}

	public String getSellerfeedback() {
		return sellerfeedback;
	}

	public void setSellerfeedback(String sellerfeedback) {
		this.sellerfeedback = sellerfeedback;
	}

	// ToString
	// method----------------------------------------------------------------------------

	@Override
	public String toString() {
		return "OrderReview [orderid=" + orderid.getUsername().getFirstname()+ "     "+orderid.getGivercode().getShopname() + ", customerrating=" + customerrating + ", sellerrating="
				+ sellerrating + ", customerfeedback=" + customerfeedback + ", sellerfeedback=" + sellerfeedback + "]";
	}

}
