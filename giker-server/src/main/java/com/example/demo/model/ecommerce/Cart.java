package com.example.demo.model.ecommerce;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.model.User;

@Entity
@Table(name = "cart")
public class Cart  {

	// Column
	// Fields----------------------------------------------------------------------------
  
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartid;

	@OneToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name = "user_name")
	private User username;

	@OneToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name = "seller_code")
	private Seller sellercode;

	@Column(name = "total_price")
	private Double totalprice;

	// CONSTRUCTORS----------------------------------------------------------------------------

	public Cart() {
	}

	

	// Column Fields -Getters and
	// Setters----------------------------------------------------------------------------

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public User getUsername() {
		return username;
	}

	public void setUsername(User username) {
		this.username = username;
	}

	public Seller getSellercode() {
		return sellercode;
	}

	public void setSellercode(Seller sellercode) {
		this.sellercode = sellercode;
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
		return "Cart [cartid=" + cartid + ", username=" + username.getUsername() + ", sellercode=" + sellercode.getShopname() + ", totalprice="
				+ totalprice + "]";
	}
	
	// Relational Fields---------------------------------------------->
	@OneToMany(mappedBy ="cart",cascade = {CascadeType.ALL})
	private Set<CartItem> cartitems;

	public Set<CartItem> getCartitems() {
		return cartitems;
	}



	public void setCartitems(Set<CartItem> cartitems) {
		this.cartitems = cartitems;
	}
public void addCartitem(CartItem item) {
		
		if(cartitems==null) {
			cartitems= new HashSet<CartItem>();
		}
		cartitems.add(item);
			
			item.setCart(this);
			
		
		
	} 
	

}
