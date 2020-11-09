package com.hkr.Models;

import java.util.Date;

public class Order {

    private int id;
    private String date;
    private double price;
    private String status;

    public Order(){}


    public Order(int id, String date, double price, String status){
        this.id = id;
        this.date = date;
        this.price = price;
        this.status =  status;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\n\tOrder{" +
                "\n\t\tid= " + id +
                "\n\t\tdate= " + date +
                "\n\t\tprice= " + price +
                "\n\t\tstatus= " + status +
                '}';
    }
}
