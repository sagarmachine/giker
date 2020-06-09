package com.example.demo.model.ecommerce;

import java.util.Arrays;
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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = { "categoryid","sellerproducts" })
@Table(name = "product")
public class Product {

	// Column
	// Fields----------------------------------------------------------------------------

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productid;

	@Column(name = "product_name")
	private String productname;

	@Column(name = "price")
	private Double price;

	@Column(name = "unit")
	private String unit;

	@Column(name = "description")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinColumn(name = "category_id")
	ProductCategory categoryid;

	@Column(name = "product_img")
	byte[] productimage;
	
	////--------Category details field--------------
	@Transient
	private String[] categorydetail;
	
	@Transient
	private int category_id;

	@Transient
	private double myprice;
	

	


	//// Constructors--------------------
	

	public Product() {
	}

	public Product(String productname, Double price, String unit, String description, ProductCategory categoryid,
			byte[] productimage, Set<ProductSeller> sellerproducts) {
		super();
		this.productname = productname;
		this.price = price;
		this.unit = unit;
		this.description = description;
		this.categoryid = categoryid;
		this.productimage = productimage;
		this.sellerproducts = sellerproducts;
	}

	public Product(String productname, Double price, String unit, ProductCategory categoryid) {
		super();
		this.productname = productname;
		this.price = price;
		this.unit = unit;
		this.categoryid = categoryid;
	}

	public Product(String productname, Double price, String unit, String description, ProductCategory categoryid) {
		super();
		this.productname = productname;
		this.price = price;
		this.unit = unit;
		this.description = description;
		this.categoryid = categoryid;
	}

	public Product(String productname, Double price, String unit, String description, ProductCategory categoryid,
			byte[] productimage) {
		super();
		this.productname = productname;
		this.price = price;
		this.unit = unit;
		this.description = description;
		this.categoryid = categoryid;
		this.productimage = productimage;
	}

	public Product(String productname, Double price, String unit, String description) {
		super();
		this.productname = productname;
		this.price = price;
		this.unit = unit;
		this.description = description;
	}

	// Setters and getters-------------------------------------
	
	public double getMyprice() {
		return myprice;
	}


	public void setMyprice(double myprice) {
		this.myprice = myprice;
	}
	
	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
	public String[] getCategorydetail() {
		System.out.println(categorydetail);
		return categorydetail;
	}

	public void setCategorydetail(String[] categorydetail) {
		this.categorydetail = categorydetail;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// @JsonIgnore
	public ProductCategory getCategoryid() {
		return categoryid;
	}

	// @JsonIgnore
	public void setCategoryid(ProductCategory categoryid) {
		this.categoryid = categoryid;
	}

	public byte[] getProductimage() {
		return productimage;
	}

	public void setProductimage(byte[] productimage) {
		this.productimage = productimage;
	}

	// ToString
	// method and equal override----------------------------------------------------------------------------

	
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname=" + productname + ", price=" + price + ", unit="
				+ unit + ", description=" + description + ", categoryid=" + categoryid.getId()+ ", productimage="
				+ Arrays.toString(productimage) + "]";
	}

	@Override
	public boolean equals(Object obj) {

		if(((Product)obj).getProductid()==this.productid)
			return true;
		return false;
	}
	
	

	


	/// Relational Fields------------------------
	
	@Transient
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	Set<ProductSeller> sellerproducts;

	public void addSellerProduct(ProductSeller p) {

		if (sellerproducts == null) {
			sellerproducts = new HashSet<ProductSeller>();
		}
		sellerproducts.add(p);

		p.setProduct(this);
	}

	public Set<ProductSeller> getSellerproducts() {
		return sellerproducts;
	}

	public void setSellerproducts(Set<ProductSeller> sellerproducts) {
		this.sellerproducts = sellerproducts;
	}
	
	

///Adding product,getting product--------------
//	private List<Product> products;
//	public  void addProduct(Product p) {
//		if(products==null) products=new ArrayList<Product>();
//		
//		products.add(p);
//		
//	}
//	
//	public List<Product> getProducts(Product p) {
//		
//		return products;
//	
//	}

}
