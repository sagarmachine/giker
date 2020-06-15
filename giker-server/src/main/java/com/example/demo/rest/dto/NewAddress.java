package com.example.demo.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewAddress {

    String house;
    String city;

    public NewAddress(String house) {
        this.house = house;
    }

    public NewAddress(String house, String city) {
        this.house = house;
        this.city = city;
    }

    public String getHouse() {
        return house;
    }

    @JsonProperty("house")
    public void setHouse(String house) {
        this.house = house;
    }

    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }
}
