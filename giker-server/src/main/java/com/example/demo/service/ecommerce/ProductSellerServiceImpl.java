package com.example.demo.service.ecommerce;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CityRepository;
import com.example.demo.dao.ecommerce.OrderRepository;
import com.example.demo.dao.ecommerce.OrderReviewRepository;
import com.example.demo.dao.ecommerce.ProductCategoryRepository;
import com.example.demo.dao.ecommerce.ProductSellerRepository;
import com.example.demo.dao.ecommerce.SellerRepository;
import com.example.demo.model.City;
import com.example.demo.model.ecommerce.OrderReview;
import com.example.demo.model.ecommerce.Product;
import com.example.demo.model.ecommerce.ProductCategory;
import com.example.demo.model.ecommerce.ProductSeller;
import com.example.demo.model.ecommerce.Seller;
import com.example.demo.rest.dto.AddMyProductRequest;
import com.example.demo.utility.IGeoLite;

@Service
public class ProductSellerServiceImpl implements IProductSellerService {
	Logger logg = Logger.getLogger(ProductSellerServiceImpl.class);
	
	@Autowired
	IGeoLite geoliteservice;
	
	@Autowired 
	CityRepository cityrepo;
	
	@Autowired
	OrderRepository orderrepo;
	
	@Autowired
	OrderReviewRepository orderreviewrepo;
	
	@Autowired
	 ProductCategoryRepository categoryrepo;
	
	@Autowired
	IProductService productservice;
	
	
	@Autowired
	private SellerRepository sellerrepo;
	
	@Autowired
	private ProductSellerRepository productsellerrepo;
	
	public List<Product> getProductsByCategoryIdAndSellerCode( int id,String code) {
		
		List<Product> productList=new ArrayList<Product>();

		Seller seller = sellerrepo.findById(code).get();	
		if(id==0) {
			List<ProductSeller>productsellers=productsellerrepo.findBySellerId(code);
			for(ProductSeller temp:productsellers) {
				temp.getProduct().setMyprice(temp.getPrice());
				productList.add(temp.getProduct());}
			return productList;
			
		}
		
		Optional<ProductCategory> value = categoryrepo.findById(id);
		
		if (value.isPresent() && seller != null) {
			
				for(ProductSeller temp: productsellerrepo.findBySellerAndProductCategoryid(seller, value.get())) {
					temp.getProduct().setMyprice(temp.getPrice());
			            productList.add(temp.getProduct());
				}
			 return productList;
		}
		else {
			throw new RuntimeException("NO PRODUCTS WITH SUCH COMBINATION CATEGORY ID: "+id +" , SELLER CODE " +code);
		}
			
		
	}
	
	
	
	
	
	


	@Override
	public List<Product>  getProductsByCategoryIdAndSellerCode2(int id,String sellercode) {

		
		List<Product> present= getProductsByCategoryIdAndSellerCode( id, sellercode);
		List<Product> all= productservice.findAllProductsByCategoryId(id);
		all.removeAll(present);
		
		return all;
		
		}



	


	@Override
	public List<Seller> getSellerListBySubServiceCode(String subservice, String search) {
		
		List<Seller> sellers = new ArrayList<Seller>();
		

		if ((search != null) && (!search.equals("")) && search.matches("[0-9]+") && search.length() > 2) {

			sellers = sellerrepo.findByIdContainingAndGivercodePincode(subservice, search);
			
			return getsellers(sellers);
			
			}
		else if ((search != null) && (!search.equals("")) && (search.matches("^[a-zA-Z]*$"))) {
			City city = cityrepo.findByName(search);
            sellers = sellerrepo.findByIdContainingAndGivercodeCity(subservice, city);
			
				 return getsellers(sellers);
			}
			

		else {
			
			String cityname;
			String ip = "2405:201:6c02:6fd9::c0a8:1d01";
			// ip=request.getRemoteAddr();
			cityname = geoliteservice.getCity(ip);
			// GeoLite code
			logg.info("city------------>" + cityname);
			City city = cityrepo.findByName(search);

			sellers = sellerrepo.findByIdContainingAndGivercodeCity(subservice, city);
			
			return getsellers(sellers);
		}

		

	}
	
	private List<Seller> getsellers(List<Seller> sellers) {
		List<Seller> result = new ArrayList<Seller>();

		
		for(Seller s:sellers) {
			int totalorder=orderrepo.countByGivercode(s);
			int totalrating=orderreviewrepo.countByOrderidGivercode(s);
			Date date=s.getGivercode().getDate();
			List<OrderReview> reviewlist=orderreviewrepo.findByOrderidGivercode(s);
			int averagerating=0;
			int count=0;
			for(OrderReview or:reviewlist) {
				count++;
				averagerating=(averagerating+or.getCustomerrating())/count;
				
			}
			String sellername=s.getGivercode().getUser().getFirstname()+" "+s.getGivercode().getUser().getLastname();
			String primaryphone=s.getGivercode().getUser().getPhone();
			s.setDatejoined(date);
			s.setTotalorder(totalorder);
			s.setAveragerating(averagerating);
			s.setTotalrating(totalrating);
			s.setSellername(sellername);
			s.setPrimaryphone(primaryphone);
		
		result.add(s);
	}
		return result;
	}



	@Override
	public String deleteMyProduct(int id, String sellercode) {

		ProductSeller ps = productsellerrepo.findByProductProductidAndSellerId(id, sellercode);

		if (ps != null) {
			productsellerrepo.deleteById(ps.getId());
			return "PRODUCT WITH ID " + id + "DELETED SUCESSFULLY";

		} else {
			return "NO PRODUCT FOUND WITH PRODUCT ID " + id;

		}

	}



	@Override
	
	public void updateMyProductPrice(String sellercode, AddMyProductRequest[] productUpdateList) {

		for(AddMyProductRequest productUpdate:productUpdateList) {
			try {
				ProductSeller product =productsellerrepo.findByProductProductidAndSellerId(productUpdate.getProductId(), sellercode);
				product.setPrice(productUpdate.getMyPrice());
				logg.info( "update to--->"+productUpdate.getMyPrice());
				productsellerrepo.save(product);
			}catch(Exception ex) {
				logg.info("EXCEPTION-->"+ex);
			}
			
			
		}
	
	}
	
		
		
		
}	


