package com.example.demo.rest.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class PlaceOrder {

    double totalPrice;
    int totalItem;
    int addressId;
    int phoneId;
    String mode;
    NewAddress address;
    String phone;
    CartProducts cartProducts[];

    public PlaceOrder(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PlaceOrder(double totalPrice, int totalItem, int addressId, int phoneId, String mode, NewAddress address, String phone, CartProducts[] cartProducts) {
        this.totalPrice = totalPrice;
        this.totalItem = totalItem;
        this.addressId = addressId;
        this.phoneId = phoneId;
        this.mode = mode;
        this.address = address;
        this.phone = phone;
        this.cartProducts = cartProducts;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @JsonProperty("totalPrice")
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalItem() {
        return totalItem;
    }

    @JsonProperty("totalItem")
    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }

    public int getAddressId() {
        return addressId;
    }

    @JsonProperty("addressId")
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getPhoneId() {
        return phoneId;
    }

    @JsonProperty("phoneId")
    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    public NewAddress getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(NewAddress address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CartProducts[] getCartProducts() {
        return cartProducts;
    }

    @JsonProperty("cartProducts")
    public void setCartProducts(CartProducts[] cartProducts) {
        this.cartProducts = cartProducts;
    }
}
