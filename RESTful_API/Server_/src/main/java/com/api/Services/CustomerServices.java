package com.api.Services;

import com.api.Data.DB;
import com.api.models.Customer;
import com.api.models.Order;

import java.util.List;

public class CustomerServices {


    private DB databaseClass = DB.getInstance();


    public Customer getCustomer(String searchedSS) {
        Customer customer = null;
        for (Customer c : databaseClass.getCustomerList()) {
            if (c.getSS().equals(searchedSS)) {
                customer = c;
            }
        }
        return customer;
    }


    public List<Customer> getCustomers() {
        return databaseClass.getCustomerList();
    }


    public Customer updateAddress(String SS, Customer customer) {

        List<Customer> list = databaseClass.getCustomerList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSS().equals(SS)) {
                list.get(i).setAddress(customer.getAddress());
            }
        }
        databaseClass.Update(list);
        return customer;
    }


    public List<Order> getOrders(String SS) {
        List<Order> customerOrders = null;
        for (Customer c : databaseClass.getCustomerList()) {
            if (c.getSS().equals(SS)) {
                customerOrders = c.getOrders();
            }
        }
        return customerOrders;
    }


}
