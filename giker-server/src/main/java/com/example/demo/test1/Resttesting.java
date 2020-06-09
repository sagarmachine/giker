package com.example.demo.test1;


import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ecommerce.ProductCategoryRepository;
import com.example.demo.model.ecommerce.ProductCategory;

@RestController
@RequestMapping("/pro")
public class Resttesting {
	
	@Autowired
	private ProductCategoryRepository repo;
	
	private List<ProductCategory> theCategories;
	EntityManager entity;
	
	@Autowired
	public Resttesting(EntityManager entity) {
		this.entity=entity;
	}
	//@Transactional
	@GetMapping("/categories")
	public List<ProductCategory> addCategory() {
		
		try {
			Session session=entity.unwrap(Session.class);
			
			Query<ProductCategory> theQuery=session.createQuery("from  ProductCategory", ProductCategory.class);
			
			theCategories= theQuery.getResultList();
			
				
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		return theCategories;
		
	}
	@Transactional
	@PostMapping("/categories")
	public ProductCategory addCategory(@RequestBody ProductCategory pc) {
		ProductCategory temppc=null;
		
		pc.setId(0);
		try {
			Session session=entity.unwrap(Session.class);
			
			session.saveOrUpdate(pc);
//			int id=(Integer)session.getIdentifier(pc);
//			temppc=session.get(ProductCategory.class, id);
			
				
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		return temppc;
	}
	
	@GetMapping("/category")
	public List<ProductCategory> findAll(){
		
		return repo.findAll();
	
	}
	
	@PostMapping("/category")
	public ProductCategory save(@RequestBody ProductCategory pc){
		return repo.save(pc);
		
		}
	
	@DeleteMapping("/category/{id}")
	public void deleteById(@PathVariable int id){
		repo.deleteById(id);;
		
		}

}
