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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product_seller")
public class ProductSeller  {

	// Column
	// Fields----------------------------------------------------------------------------

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(fetch =FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne(fetch =FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
	@JoinColumn(name = "seller_code")
	private Seller seller;

	@Column(name = "stock")
	private int stock;

	@Column(name = "price")
	private Double price;
	// CONSTRUCTORS----------------------------------------------------------------------------

	public ProductSeller() {
	}

	

	public ProductSeller(int stock, Double price) {
		super();
		this.stock = stock;
		this.price = price;
	}
	



	public ProductSeller(Product product, Seller seller, int stock, Double price) {
		super();
		this.product = product;
		this.seller = seller;
		this.stock = stock;
		this.price = price;
	}



	// Column Fields -Getters and
	// Setters----------------------------------------------------------------------------

	public int getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	// ToString
	// method----------------------------------------------------------------------------

	@Override
	public String toString() {
		return "ProductSeller [id=" + id + ", productid=" + product.getProductname() + ", seller=" + seller.getShopname() + ", stock="
				+ stock + ", price=" + price + "]";
	}
	
	//Relational mapping------------------------------------
	
	@OneToMany(mappedBy = "productid", cascade = { CascadeType.ALL })
	private Set<OrderItem> orderitems;
	
	public Set<OrderItem> getOrderitems() {
		return orderitems;
	}



	public void setOrderitems(Set<OrderItem> orderitems) {
		this.orderitems = orderitems;
	}



	public void addCartitem(OrderItem item) {

		if (orderitems == null) {
			orderitems = new HashSet<OrderItem>();
		}
		orderitems.add(item);

		item.setProductid(this);

	}
//	
//	@OneToMany(mappedBy = "productseller",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
//	Set<CartItem> cartproducts;
//
//	public Set<CartItem> getCartproducts() {
//		return cartproducts;
//	}
//
//	public void setCartproducts(Set<CartItem> cartproducts) {
//		this.cartproducts = cartproducts;
//	}
//	
//	public void addCartProducts(CartItem item) {
//		
//		if(cartproducts==null) {
//			cartproducts= new HashSet<CartItem>();
//		}
//		cartproducts.add(item);
//			
//			item.setProductseller(this);
//	}
//	
	

}
