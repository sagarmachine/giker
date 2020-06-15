package com.example.demo.rest;


import com.example.demo.rest.dto.PlaceOrder;
import com.example.demo.service.ecommerce.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRest {

    @Autowired
    IOrderService orderService;

    @PostMapping("placeOrder/{username}/{sellercode}")
    public  void placeOrder(@PathVariable("usermname")String username, @PathVariable ("sellercode")String sellercode, @RequestBody PlaceOrder order){

  orderService.placeOrder(username,sellercode,order);

    }

}
