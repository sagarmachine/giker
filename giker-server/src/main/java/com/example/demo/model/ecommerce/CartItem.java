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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_item")
public class CartItem  {
	// Column
	// Fields----------------------------------------------------------------------------

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.PERSIST})
	@JoinColumn(name = "cart_id")
	private Cart cart;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH,CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "products_id")
	private ProductSeller productseller;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "total_price")
	private Double totalprice;

	// CONSTRUCTORS----------------------------------------------------------------------------

	public CartItem() {
	}

	

	// Column Fields -Getters and
	// Setters----------------------------------------------------------------------------

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public ProductSeller getProductseller() {
		return productseller;
	}

	public void setProductseller(ProductSeller productseller) {
		this.productseller = productseller;
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



	@Override
	public String toString() {
		return "CartItem [id=" + id + ", cart=" + cart.getCartid() + ", productseller=" + productseller.getId() + ", quantity=" + quantity
				+ ", totalprice=" + totalprice + "]";
	}

	// ToString
	// method----------------------------------------------------------------------------
	
	

}
