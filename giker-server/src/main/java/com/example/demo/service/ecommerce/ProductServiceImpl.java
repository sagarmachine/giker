package com.example.demo.service.ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ecommerce.ProductCategoryRepository;
import com.example.demo.dao.ecommerce.ProductRepository;
import com.example.demo.model.ecommerce.Product;
import com.example.demo.model.ecommerce.ProductCategory;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private ProductRepository productrepo;
	
	@Autowired
	private ProductCategoryRepository categoryrepo;
	
	

	
	public List<Product> findAllProductsByCategoryId( int id)
	{  Optional<ProductCategory> value=categoryrepo.findById(id);
	if(value.isPresent()) {	
	ProductCategory pc=value.get(); 

	List<Product> products=new ArrayList<Product>();
	for(Product p: productrepo.findByCategoryidOrderByProductname(pc)) {
		ProductCategory temp=p.getCategoryid();
		p.setCategorydetail(new String[] {temp.getId()+"",temp.getProductcategory()});
		products.add(p);
	}
	
	return products;
	}
	else
		throw new  RuntimeException("No Category Found With ID "+ id);
		
	}
	
public Product findProductByProductId( int id){
		
		Optional<Product> value = productrepo.findById(id);
		if(value.isPresent()) {
			int cid=value.get().getCategoryid().getId();
			String cname=value.get().getCategoryid().getProductcategory();
			value.get().setCategory_id(cid);
			value.get().setCategorydetail(new String[] {cid+"",cname});
			return value.get();
			//String code=value.get().getCategorydetail().toString();
			//logg.info("-----------code="+value.get());
			
		}
		else
			throw new  RuntimeException("No Category Found With ID "+ id);
		
			
	
	}


public List<Product> add( Product[] p){
	
	List<Product> result = new ArrayList<Product>();
	for (Product temp : p) {
		Optional<ProductCategory> value = categoryrepo.findById(temp.getCategory_id());
		if (value.isPresent()) {

			ProductCategory pc = value.get();
			temp.setCategoryid(pc);
			temp.setCategorydetail(new String[] { pc.getId() + "", pc.getProductcategory() });
			pc.addProduct(temp);
			result.add(productrepo.save(temp));
		}

	}
	return result;

	}


public Product update( int id, Product pc ){
	
	Optional<Product> value = productrepo.findById(id);
	if(value.isPresent()) {
		
		pc.setProductid(id);
		pc.setCategoryid(value.get().getCategoryid());
		return productrepo.save(pc);
	}
	else
		throw new  RuntimeException("No Category Found With ID "+ id);
	
	
	}

public boolean deleteById( int id){

	Optional<Product> value = productrepo.findById(id);
	if(value.isPresent()) {
		Product p= value.get();
		ProductCategory pc=p.getCategoryid();
		pc.removeProduct(p);
		productrepo.deleteById(id);
		return true;
	
	}
	else
		throw new  RuntimeException("No Category Found With ID "+ id);
}

@Override
public List<Product> findAll() {
	
	return productrepo.findAll();
}

}
