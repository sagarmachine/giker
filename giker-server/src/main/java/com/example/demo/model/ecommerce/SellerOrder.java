package com.example.demo.model.ecommerce;

import java.util.Date;
import java.util.Set;

public class SellerOrder {
private int orderid;
	
	private Date date;

	private char status;
	
	private int totalitems;

	private Double totalprice;
	
private String mode;
	
	private String requestedtime;
	
	private String customername;
	
	
	private String deliveryaddress;
	
	
	private String contactno;
	
	private Set<OrderItem> orderitems;
/////////////////---constructors
	
	
	public SellerOrder() {}
	public SellerOrder(int orderid, Date date, char status, int totalitems, Double totalprice, String customername,
			 String deliveryaddress, String contactno, Set<OrderItem> orderitems,String mode,String requestedtime) {
		super();
		this.orderid = orderid;
		this.date = date;
		this.status = status;
		this.totalitems = totalitems;
		this.totalprice = totalprice;
		this.customername = customername;
		this.mode = mode;
		this.requestedtime = requestedtime;
		this.deliveryaddress = deliveryaddress;
		this.contactno = contactno;
		this.orderitems = orderitems;
	}
	
	
//////////////////////////////==========setters and getters	

	
	public int getOrderid() {
		return orderid;
	}

	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getRequestedtime() {
		return requestedtime;
	}
	public void setRequestedtime(String requestedtime) {
		this.requestedtime = requestedtime;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
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

	public int getTotalitems() {
		return totalitems;
	}

	public void setTotalitems(int totalitems) {
		this.totalitems = totalitems;
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

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	
	public String getDeliveryaddress() {
		return deliveryaddress;
	}

	public void setDeliveryaddress(String deliveryaddress) {
		this.deliveryaddress = deliveryaddress;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public Set<OrderItem> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(Set<OrderItem> orderitems) {
		this.orderitems = orderitems;
	}

	
	
	



}
