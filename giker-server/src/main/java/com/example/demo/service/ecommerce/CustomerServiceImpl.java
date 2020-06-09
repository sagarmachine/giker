package com.example.demo.service.ecommerce;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserAddressRepository;
import com.example.demo.dao.UserPhoneRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dao.ecommerce.OrderRepository;
import com.example.demo.model.User;
import com.example.demo.model.UserAddress;
import com.example.demo.model.UserPhone;
import com.example.demo.model.ecommerce.Customer;
import com.example.demo.model.ecommerce.CustomerOrder;
import com.example.demo.model.ecommerce.Order;
import com.example.demo.model.ecommerce.OrderItem;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	UserPhoneRepository userphonerepo;
	
	@Autowired
	UserAddressRepository useraddressrepo;
	
	@Autowired
	OrderRepository orderrepo;
	
	public Customer getCustomerDetail(String username) {
		List<Order> totalorders=orderrepo.findByUsernameUsernameOrderByDate(username);
		List<Order> pendingorders=orderrepo.findByUsernameUsernameAndStatusOrderByDate(username,'P');
		List<Order> confirmedorders=orderrepo.findByUsernameUsernameAndStatusOrderByDate(username,'C');
		List<Order> declinedorders=orderrepo.findByUsernameUsernameAndStatusOrderByDate(username,'D');
		Customer c=new Customer();
		List<String> phone = new ArrayList<String>();
		List<String> address =new ArrayList<String>();
		User user=userrepo.findByUsername(username);
		c.setUsername(user.getUsername());
		c.setName(user.getFirstname()+" "+user.getLastname());
		c.setEmail(user.getEmail());
		c.setPrimaryphone(user.getPhone());
		c.setTotalorders(totalorders.size());
		c.setPendingorders(pendingorders.size());
		c.setConfirmedorders(confirmedorders.size());
		c.setDeclinedorders(declinedorders.size());
		c.setRequestedtime(LocalTime.now()+"");
		List<UserPhone> phones= userphonerepo.findByUseridUsername(username);
		if(phones!=null) {
		for(UserPhone p:phones) {
			
			phone.add(p.getPhone());
			
			}
		c.setPhone(phone);
		}
		List<UserAddress> addresses=useraddressrepo.findByUseridUsername(username);
		if(addresses!=null) {
		for(UserAddress addr:addresses) {
			
			
			String Address=addr.getHouseno()+" $%,"+addr.getCity()+" ,"+addr.getPincode()+" ,"+addr.getState()+" ,"+addr.getCountry();
			
			address.add(Address);
			}
		}
		c.setAddress(address);
		
		return c;
		
	}

	@Override
	public List<CustomerOrder> getCustomerOrdersByUserName(String username) {
		
	List<Order> orders=orderrepo.findByUsernameUsernameOrderByDate(username);
	
		return addOrderDetails(orders);
	}

	@Override
	public List<CustomerOrder> getCustomerPendingOrdersByUserName(String username) {
		List<Order> orders =orderrepo.findByUsernameUsernameAndStatusOrderByDate(username,'P');
		return addOrderDetails(orders);
	}

	@Override
	public List<CustomerOrder> getCustomerConfirmedOrdersByUserName(String username) {
		List<Order> orders =orderrepo.findByUsernameUsernameAndStatusOrderByDate(username,'C');
		return addOrderDetails(orders);
	}

	
	private List<CustomerOrder> addOrderDetails(List<Order> orders){
		List<CustomerOrder> result=new ArrayList<CustomerOrder>();
		for(Order order:orders) {
			UserAddress add=order.getDeliveryaddressid();
			String address="SELF- PICKUP";
					if(add!=null)
			 address=add.getHouseno()+" $%,"+add.getCity()+", "+add.getState()+", "+add.getPincode()+", "+add.getCountry();
			order.setCustomername(order.getUsername());
			order.setCustomerphone(order.getContactno());
			User user=order.getGivercode().getGivercode().getUser();
			order.setSellername(user.getFirstname()+"  "+user.getLastname());
			order.setSellerphone(order.getGivercode().getSecondaryphone());
			String selleraddress=order.getGivercode().getShopname()+", "+order.getGivercode().getShopaddress();
			
			int count=0;
			Set<OrderItem> items=order.getOrderitems();
			for(OrderItem item:items) {
				item.setProductname(item.getProductid());
				item.setPrice(item.getProductid());
				count++;
			}
			order.setTotalitems(count);
		  result.add(new CustomerOrder(order.getOrderid(),order.getDate(),order.getStatus(),order.getTotalitems(),order.getTotalprice()
				  ,order.getSellername(),order.getSellerphone(),address,order.getContactno().getPhone(),
				  order.getOrderitems(),order.getMode(),LocalTime.now()+"",selleraddress));	
		
		}
			
			
			return result;
		
	}
}
