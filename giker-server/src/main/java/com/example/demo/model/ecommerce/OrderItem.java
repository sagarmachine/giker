package com.example.demo.model.ecommerce;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "order_item")
@JsonIgnoreProperties({"orderid","productid","id"})
public class OrderItem {

	// Column
	// Fields----------------------------------------------------------------------------
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.PERSIST})
	@JoinColumn(name = "order_id")
	private Order orderid;

	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.PERSIST})
	@JoinColumn(name = "product_id")
	private ProductSeller productid;

	@Column(name = "quantity")
	private int quantity;
	
/////////product name and price/quantity
	@Transient
	private String Productname;
		
	@Transient
	private Double price;	
		
	@Column(name = "total_price")
	private Double totalprice;
	
	

	// CONSTRUCTORS----------------------------------------------------------------------------

	

	public OrderItem() {
	}

	public String getProductname() {
		return Productname;
	}

	public void setProductname(ProductSeller productid) {
		Productname = productid.getProduct().getProductname();
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(ProductSeller productid) {
		this.price = productid.getPrice();
	}

	public OrderItem(int quantity) {

		this.quantity = quantity;
	}

	// Column Fields -Getters and
	// Setters----------------------------------------------------------------------------

	public Order getOrderid() {
		return orderid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOrderid(Order orderid) {
		this.orderid = orderid;
	}

	public ProductSeller getProductid() {
		return productid;
	}

	public void setProductid(ProductSeller productid) {
		this.productid = productid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	// ToString
	// method----------------------------------------------------------------------------

	@Override
	public String toString() {
		return "OrderItem [orderid=" + orderid + ", productid=" + productid + ", quantity=" + quantity + ", totalprice="
				+ totalprice + "]";
	}

}
