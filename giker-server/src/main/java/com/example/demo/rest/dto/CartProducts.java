package com.example.demo.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartProducts {

    int id;
    int quatity;
    int total;

    public CartProducts(int id, int quatity, int total) {
        this.id = id;
        this.quatity = quatity;
        this.total = total;
    }

    public CartProducts(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }

    public int getQuatity() {
        return quatity;
    }

    @JsonProperty("quantity")
    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    public int getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(int total) {
        this.total = total;
    }
}
