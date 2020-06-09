package com.example.demo.service.ecommerce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SubServiceRepository;
import com.example.demo.dao.ecommerce.ProductCategoryRepository;
import com.example.demo.dao.ecommerce.ProductCategorySellerRepository;
import com.example.demo.dao.ecommerce.ProductRepository;
import com.example.demo.dao.ecommerce.ProductSellerRepository;
import com.example.demo.model.SubService;
import com.example.demo.model.ecommerce.Product;
import com.example.demo.model.ecommerce.ProductCategory;
import com.example.demo.model.ecommerce.ProductCategorySeller;
import com.example.demo.model.ecommerce.ProductSeller;


@Service
public class ProductCategorySellerServiceImpl implements IProductCategorySellerService {
	
	
	@Autowired
	ProductSellerRepository productsellerrepo;
	
	@Autowired
	ProductCategoryRepository categoryrepo;
	
	@Autowired
	ProductRepository productrepo;
	
	@Autowired
	SubServiceRepository subservicerepo;
	
	@Autowired
	ProductCategorySellerRepository pcsrepo;
	
	
	public List<String> addsubserviceCategory( ProductCategorySeller[] pcs) {

		List<String> result = new ArrayList<>();

		for (ProductCategorySeller temp : pcs) {

			Optional<ProductCategory> value = categoryrepo.findById(temp.getCategoryid());

			SubService service = subservicerepo.findByCode(temp.getService());
			String s = service.getCode();

			if (value.isPresent() && s.equals(temp.getService())) {

				pcsrepo.save(new ProductCategorySeller(value.get(), service, temp.getCategoryid(), temp.getService()));

			} else
				throw new RuntimeException("NO COMBINATION FOUND WITH CategoryID  :" + temp.getCategoryid()
						+ "And SubService" + temp.getService());

		}

		return result;
	}
	
	public List<ProductCategorySeller> findAll(){
		List<ProductCategorySeller> temp=new ArrayList<>();
		for(ProductCategorySeller pcs:pcsrepo.findAll())
		{
			pcs.setCategoryid(pcs.getProductcategory().getId());
			pcs.setService(pcs.getSubservice().getCode());
			temp.add(pcs);
		}
		return temp;
	}
	
	
public ProductCategorySeller findById(int id){
		
		
		Optional<ProductCategorySeller> value=pcsrepo.findById(id);
		if(value.isPresent()) {
		return value.get();
	}
		else
			throw new RuntimeException("NO COMBINATION FOUND WITH ID  :"+id);
	}
	

public HashMap<Integer,String> getProductCategoryBySubServiceCode(String code)
{ List<ProductCategorySeller> list=findAll();
HashMap<Integer,String> result=new HashMap<Integer,String>();
for(ProductCategorySeller p:list) {
	String s=p.getSubservice().getCode();
	if(s.equals(code)) {
		result.put(p.getProductcategory().getId(),p.getProductcategory().getProductcategory());
	}
	}
	
	
return result;
}



public List<HashMap<String,String[]>> getProductCategoryByUserSubServiceCode( String usersubservice) {
int i=usersubservice.indexOf('_');
String code=usersubservice.substring(i+1);
List<ProductCategorySeller> list=pcsrepo.findAll();
List<HashMap<String, String[]>>categories= new ArrayList();

for(ProductCategorySeller p:list) {
String s=p.getSubservice().getCode();
if(s.equals(code)) {
HashMap<String, String[]> result=new HashMap<String,String[]>();
String[] a= new String[2];
a[0]=p.getProductcategory().getId()+"";
a[1]=p.getProductcategory().getProductcategory();
result.put("category",a);
categories.add(result);

}
}


return categories;


}

public boolean deleteById( int id){
	
	try {
	Optional<ProductCategorySeller> value=pcsrepo.findById(id);
	if(value.isPresent()) {
	pcsrepo.delete(value.get());
	
	return true;
            }
	else
		throw new RuntimeException("NO COMBINATION FOUND WITH ID  :"+id);
}catch(Exception ex) {
  System.out.println(ex);
}
return false;
}

@Override
public List<Product> getProductsBySellerCode(String seller) {
	
	int i=seller.indexOf('_');
	String subservice= seller.substring(i+1);
	 ProductCategorySeller temp=pcsrepo.findFirstBySubserviceCode(subservice);
	 
	 ProductCategory category=temp.getProductcategory();
	 
	 List<Product> result =productrepo.findByCategoryid(category);
	 

	return result;
}

@Override
public List<Product> getRemainingProductsBySellerCode(String seller) {
	List<Product> all = getProductsBySellerCode(seller);
	List<Product> present = new ArrayList<Product>();

	int i = seller.indexOf('_');
	String subservice = seller.substring(i + 1);
	ProductCategorySeller temp = pcsrepo.findFirstBySubserviceCode(subservice);

	ProductCategory category = temp.getProductcategory();

	List<ProductSeller> productseller = productsellerrepo.findByProductCategoryidAndSellerId(category, seller);

	for (ProductSeller ps : productseller) {
		present.add(ps.getProduct());
	}
	all.removeAll(present);

	return all;
}




}
	
