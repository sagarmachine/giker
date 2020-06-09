package com.example.demo.service.ecommerce;

import java.util.List;

import com.example.demo.model.ecommerce.Customer;
import com.example.demo.model.ecommerce.CustomerOrder;

public interface ICustomerService {

	Customer getCustomerDetail(String username);

	List<CustomerOrder> getCustomerOrdersByUserName(String username);

	List<CustomerOrder> getCustomerPendingOrdersByUserName(String username);

	List<CustomerOrder> getCustomerConfirmedOrdersByUserName(String username);

}
