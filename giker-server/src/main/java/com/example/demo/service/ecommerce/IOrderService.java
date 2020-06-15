package com.example.demo.service.ecommerce;

import com.example.demo.rest.dto.PlaceOrder;

public interface IOrderService {

    void placeOrder(String username, String sellercode, PlaceOrder order);
}
