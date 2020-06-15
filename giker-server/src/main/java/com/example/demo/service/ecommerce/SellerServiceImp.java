package com.example.demo.service.ecommerce;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ecommerce.OrderRepository;
import com.example.demo.dao.ecommerce.ProductRepository;
import com.example.demo.dao.ecommerce.ProductSellerRepository;
import com.example.demo.dao.ecommerce.SellerRepository;
import com.example.demo.model.User;
import com.example.demo.model.UserAddress;
import com.example.demo.model.ecommerce.CustomerOrder;
import com.example.demo.model.ecommerce.Order;
import com.example.demo.model.ecommerce.OrderItem;
import com.example.demo.model.ecommerce.Product;
import com.example.demo.model.ecommerce.ProductSeller;
import com.example.demo.model.ecommerce.Seller;
import com.example.demo.model.ecommerce.SellerOrder;
import com.example.demo.rest.dto.AddMyProductRequest;

@Service
public class SellerServiceImp implements ISellerService {
	
	Logger logg= Logger.getLogger(SellerServiceImp.class);

	@Autowired
	SellerRepository sellerrepo;
	
	@Autowired
	ProductRepository productrepo;
	
	@Autowired
    ProductSellerRepository productsellerrepo;
	
	@Autowired
	OrderRepository orderrepo;
	
	
	
	
	@Override
	public String addMyProduct(AddMyProductRequest newproduct,String usersubservicecode) {
      
		
		
		
		try {
			 logg.info("Seller=>"+usersubservicecode);
          Seller seller = sellerrepo.findById(usersubservicecode).get();
          logg.info("Product=>"+newproduct.getProductId());
		 Product product = productrepo.findById(newproduct.getProductId()).get();
		 ProductSeller productseller= new ProductSeller(0,newproduct.getMyPrice()==-1?product.getPrice():newproduct.getMyPrice());
		 
		 
		 seller.addSellerProduct(productseller);
		 product.addSellerProduct(productseller);
		 
		 sellerrepo.save(seller);
		 productrepo.save(product);
		 
		}
		catch(Exception ex) {
			logg.info("EXCEPTION-->"+ex);
			return "FAILED";
		}
		 return "SUCCESS";
		
		
	}

	@Override
	public List<SellerOrder> getSellerPendingOrdersBySellerCode(String sellercode) {
		
		
		List<Order> orders= orderrepo.findByGivercodeIdAndStatusOrderByDate(sellercode,'P');
		
		
		return addOrderDetails(orders);
	}
	
	

	private List<SellerOrder> addOrderDetails(List<Order> orders){
	List<SellerOrder> result=new ArrayList<SellerOrder>();
	for(Order order:orders) {
		UserAddress add=order.getDeliveryaddressid();
		String address="SELF-PICKUP";
		if(add!=null)		
		address=add.getHouseno()+", "+add.getCity()+", "+add.getState()+", "+add.getPincode()+", "+add.getCountry();
		order.setCustomername(order.getUsername());
		order.setCustomerphone(order.getContactno());
		User user=order.getGivercode().getGivercode().getUser();
		order.setSellername(user.getFirstname()+"  "+user.getLastname());
		order.setSellerphone(order.getGivercode().getSecondaryphone());
		int count=0;
		Set<OrderItem> items=order.getOrderitems();
		for(OrderItem item:items) {
			item.setProductname(item.getProductid());
			item.setPrice(item.getProductid());
			count++;
		}
		order.setTotalitems(count);
		result.add(new SellerOrder(order.getOrderid(),order.getDate(),order.getStatus(),order.getTotalitems(),order.getTotalprice()
				  ,user.getFirstname()+" "+user.getLastname(),address,order.getContactno().getPhone(),order.getOrderitems(),order.getMode(),LocalTime.now()+""));	
		
	}
			
		return result;
	}

	@Override
	public List<SellerOrder> getSellerConfirmedOrdersBySellerCode(String sellercode) {
		
        List<Order> orders= orderrepo.findByGivercodeIdAndStatusOrderByDate(sellercode,'C');
		
		
		return addOrderDetails(orders);
		
		
	}

	@Override
	public List<SellerOrder> getSellerConfirmedOrdersBySellerCodeAndDate(String sellercode, String date) {
		if(date.length()==1) {
		return getSellerConfirmedOrdersBySellerCode(sellercode) ;
		}
		else
		{   
			
			
			List<Order> orders=null;
			try {
				Date d= new SimpleDateFormat("dd-MM-yyyy").parse(date);
				logg.info("Date=>"+d);
				orders = orderrepo.findByGivercodeIdAndDateeAndStatusOrderByDate(sellercode,d,'C');

				
				
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return addOrderDetails(orders); 
		}
			
	}
	
}
