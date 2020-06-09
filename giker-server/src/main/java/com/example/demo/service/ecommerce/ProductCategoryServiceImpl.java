package com.example.demo.service.ecommerce;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ecommerce.ProductCategoryRepository;
import com.example.demo.model.ecommerce.ProductCategory;

@Service
public class ProductCategoryServiceImpl implements IProductCategoryService {
	
	Logger logg = Logger.getLogger(ProductCategoryServiceImpl.class);
	
	@Autowired
	private ProductCategoryRepository categoryrepo;

	@Override
	public boolean addProductCategory(ProductCategory pc) {
		
		try {
		
			categoryrepo.save(pc);
			return true;
			
		}catch(Exception ex) {
			logg.info("EXCEPTION--->"+ex);
		}
			
			return false;
	}

	@Override
	public boolean deleteById(int id) {
		try {
			
			categoryrepo.deleteById(id);
			return true;
			
		}catch(Exception ex) {
			logg.info("EXCEPTION--->"+ex);
		}
			
			return false;
	}

	@Override
	public ProductCategory update(int id, ProductCategory pc) {
		try {
		Optional<ProductCategory> value = categoryrepo.findById(id);
		if(value.isPresent()) {
			pc.setId(id);
			return categoryrepo.save(pc);
		}
		else
			throw new  RuntimeException("No Category Found With ID "+ id);
		
		
		}
	catch(Exception ex) {
		logg.info("EXCEPTION--->"+ex);
	}
	 return null;
		
	}

	@Override
	public List<ProductCategory> findAll() {
		
		return categoryrepo.findAll();
	}

	@Override
	public ProductCategory findById(int id) {
		try {
		Optional<ProductCategory> value = categoryrepo.findById(id);
		if(value.isPresent()) {
			return value.get();
			}
		else
			throw new  RuntimeException("No Category Found With ID "+ id);
		}catch(Exception ex) {
			logg.info("EXCEPTION--->"+ex);
			
		}
	return null;
	}

	
	
	
	
}
