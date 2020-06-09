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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product_category")
public class ProductCategory {

	// Column
	// Fields----------------------------------------------------------------------------

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "product_category")
	private String productcategory;

	// CONSTRUCTORS----------------------------------------------------------------------------

	public ProductCategory() {
	}

	public ProductCategory(String productcategory) {
		super();

		this.productcategory = productcategory;
	}

	// Column Fields -Getters and
	// Setters----------------------------------------------------------------------------

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductcategory() {
		return productcategory;
	}

	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}

//ToString method----------------------------------------------------------------------------

	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", productcategory=" + productcategory + ", products=" + products.size()
				+ ", productcategorysellers=" + productcategorysellers.size() + "]";
	}

//// Relational Fields
	// @Transient
	// mappedBy="categoryid"
	@OneToMany(mappedBy = "categoryid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Product> products;

	// to set products--------------------------->
	public void addProduct(Product product) {

		if (products == null) {
			products = new HashSet<Product>();
		}
//		ProductCategory pc=product.getCategoryid();
//		product.setCategorydetail(new String[] {pc.getId()+"",pc.getProductcategory()});
		products.add(product);

		product.setCategoryid(this);

	}

	public void removeProduct(Product product) {

		products.remove(product);
		product.setCategoryid(null);
	}

	public Set<Product> getProducts() {
		 Set<Product> products=new HashSet<Product>();
		for(Product p:this.products) {
			ProductCategory pc=p.getCategoryid();
			p.setCategorydetail(new String[] {pc.getId()+"",pc.getProductcategory()});
			products.add(p);
		
		}
		

		return products;

	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	// ProductCategorySeller Realtion------------------------->

	// @Transient
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productcategory", cascade = CascadeType.ALL)
	Set<ProductCategorySeller> productcategorysellers;

	public void addProductCategorySellers(ProductCategorySeller p) {

		if (productcategorysellers == null)
			productcategorysellers = new HashSet<ProductCategorySeller>();

		productcategorysellers.add(p);

		p.setProductcategory(this);

	}
	
	public Set<ProductCategorySeller> getProductCategorySellers(){
		
		return productcategorysellers;
	}

	public Set<ProductCategorySeller> getProductcategorysellers() {
		return productcategorysellers;
	}

	public void setProductcategorysellers(Set<ProductCategorySeller> productcategorysellers) {
		this.productcategorysellers = productcategorysellers;
	}

}