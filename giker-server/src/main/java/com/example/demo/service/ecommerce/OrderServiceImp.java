package com.example.demo.service.ecommerce;

import com.example.demo.dao.UserAddressRepository;
import com.example.demo.dao.UserPhoneRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dao.ecommerce.ProductSellerRepository;
import com.example.demo.dao.ecommerce.SellerRepository;
import com.example.demo.model.User;
import com.example.demo.model.UserAddress;
import com.example.demo.model.UserPhone;
import com.example.demo.model.ecommerce.*;
import com.example.demo.rest.dto.PlaceOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImp implements  IOrderService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    UserAddressRepository userAddressRepository;

    @Autowired
    UserPhoneRepository userPhoneRepository;

    @Autowired
    ProductSellerRepository productSellerRepository;

    @Override
    public void placeOrder(String username, String sellercode, PlaceOrder order) {

        User user = userRepository.findByUsername(username);
        Seller seller = sellerRepository.findById(sellercode).get();

        UserAddress userAddress=null;
        if(order.getAddress()==null){
             userAddress= new UserAddress();
            userAddress.setHouseno(order.getAddress().getHouse());
            userAddress.setCity(order.getAddress().getCity());
            user.addUserAddress(userAddress);
        }else
            userAddress= userAddressRepository.findById(order.getAddressId()).get();


        UserPhone userPhone= null;

        if(order.getPhone()==null){
            userPhone= new UserPhone(order.getPhone());
            user.addUserPhone(userPhone);
          }else
          userPhone=userPhoneRepository.findById(order.getPhoneId()).get();

        Order newOrder= new Order(new Date(),new Date(),'P',userAddress,userPhone,order.getTotalPrice(),order.getMode());

        for (int i=0;i<order.getCartProducts().length;i++){
            ProductSeller productSeller= productSellerRepository.findById(order.getCartProducts()[i].getId()).get();
            OrderItem orderItem= new OrderItem(order.getCartProducts()[i].getQuatity());
            productSeller.addCartitem(orderItem);
            newOrder.addOrderitem(orderItem);
        }

        user.addCartitem(newOrder);
        seller.addCartitem(newOrder);

        userRepository.save(user);
        sellerRepository.save(seller);





    }
}
