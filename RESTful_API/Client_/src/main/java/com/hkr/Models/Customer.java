package com.hkr.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String SS;
    private String name;
    private String address;
    private String gender;
    private List<Order> orders = new ArrayList<>();


    public Customer(){
        orders = new ArrayList<Order>();
    }

    public Customer(String SS, String name) {
        this.SS = SS;
        this.name = name;
        orders = new ArrayList<Order>();
    }


    @JsonProperty("SS")
    public String getSS() {
        return SS;
    }

    public void setSS(String SS) {
        this.SS = SS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public List<Order> getOrders(){
        return orders;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "\n\tSS=" + SS +
                "\n\tname='" + name +
                "\n\taddress='" + address +
                "\n\tgender='" + gender +
                "\n\torders="+ orders.toString();
    }
}
