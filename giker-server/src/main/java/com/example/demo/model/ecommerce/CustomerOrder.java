package com.example.demo.model.ecommerce;

import java.util.Date;
import java.util.Set;

public class CustomerOrder {
	
	private int orderid;
	
	private Date date;

	private char status;
	private int totalitems;

	private Double totalprice;
	
	private String mode;
	
	private String requestedtime;
	
	
	private String sellername;
	
	
	private String sellerphone;
	
	private String selleraddress;
	
	
	
	private String deliveryaddress;
	
	
	private String contactno;
	
	private Set<OrderItem> orderitems;
/////////////////---constructors
	
	
	public CustomerOrder() {}
	public CustomerOrder(int orderid, Date date, char status, int totalitems, Double totalprice, String sellername,
			String sellerphone, String deliveryaddress, String contactno, Set<OrderItem> orderitems,String mode,String requestedtime,String selleraddress) {
		super();
		this.orderid = orderid;
		this.date = date;
		this.status = status;
		this.totalitems = totalitems;
		this.totalprice = totalprice;
		this.sellername = sellername;
		this.sellerphone = sellerphone;
		this.deliveryaddress = deliveryaddress;
		this.contactno = contactno;
		this.orderitems = orderitems;
		this.mode = mode;
		this.requestedtime = requestedtime;
		this.selleraddress=selleraddress;
	}
	
	
//////////////////////////////==========setters and getters	

	public String getSelleraddress() {
		return selleraddress;
	}
	public void setSelleraddress(String selleraddress) {
		this.selleraddress = selleraddress;
	}

	
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
