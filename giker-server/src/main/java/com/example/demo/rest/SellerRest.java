package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ecommerce.OrderRepository;
import com.example.demo.model.ecommerce.Order;
import com.example.demo.model.ecommerce.SellerOrder;
import com.example.demo.rest.dto.AddMyProductRequest;
import com.example.demo.rest.dto.AddMyProductResponse;
import com.example.demo.service.ecommerce.ISellerService;

@CrossOrigin( origins="http://localhost:3000")
@RestController
public class SellerRest {

	
	@Autowired
	ISellerService sellerservice;
	
	@Autowired
	OrderRepository orderrepo;

	
	
	
	Logger logg =Logger.getLogger(SellerRest.class);
	
	@PostMapping(value ="/addMyProducts")
	public AddMyProductResponse addMyProduct(@RequestParam("usersubservicecode")String usersubservicecode,@RequestBody AddMyProductRequest[] productList) {
		
		List<String>result= new ArrayList<String>();
		for(AddMyProductRequest product:productList) {
		 result.add(sellerservice.addMyProduct(product,usersubservicecode));
		}
		if(result.contains("FAILED"))
			return new AddMyProductResponse("PLEASE TRY TO SAVE AGAIN");
		return new AddMyProductResponse("SAVED SUCCESSFULLY");
	}
	
	@GetMapping("/getSellerPendingOrdersBySellerCode")
	public List<SellerOrder> getSellerPendingOrdersBySellerCode(@RequestParam("sellercode") String sellercode) {
		
		
		return sellerservice.getSellerPendingOrdersBySellerCode(sellercode);
	}
	
	@GetMapping("/getSellerConfirmedOrdersBySellerCode")
	public List<SellerOrder> getSellerConfirmedOrdersBySellerCode (@RequestParam("sellercode") String sellercode) {
	
		return sellerservice.getSellerConfirmedOrdersBySellerCode(sellercode);
	}
	
	@GetMapping("/getSellerConfirmedOrdersBySellerCodeAndDate")
	public List<SellerOrder> getSellerConfirmedOrdersBySellerCodeAndDate (@RequestParam("sellercode") String sellercode,@RequestParam("date") String date) {
		
		return sellerservice.getSellerConfirmedOrdersBySellerCodeAndDate(sellercode,date);
	}
	
	@GetMapping("/completeOrder")
	public void completeOrder(@RequestParam("id")int id) {
		Order order=orderrepo.findById(id).get();
		
		order.setStatus('C');
		
		orderrepo.save(order);
		
	}
	
	
	@GetMapping("/declineOrder")
	public void declineOrder(@RequestParam("id")int id) {
Order order=orderrepo.findById(id).get();
		
		order.setStatus('D');
		
		orderrepo.save(order);
		
	}
	
}


