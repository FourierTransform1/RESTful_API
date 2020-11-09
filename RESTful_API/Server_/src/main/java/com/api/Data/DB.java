package com.api.Data;

import com.api.models.Customer;
import com.api.models.Order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DB {


    private static DB DB_Instance;
    private List<Customer> customerList = new ArrayList<>();

    public void populateWithDummy(){
        //Customer1
        Customer customer1 = new Customer("1234" ,"Ahmed Mohamud" ,"123gatan" , "Male");
        Order order1 = new Order(1,getDate(),25.30,"Paid" );
        Order order2 = new Order(1,getDate(),12.99,"Paid" );
        customer1.addOrder(order1);
        customer1.addOrder(order2);
        customerList.add(customer1);

        //Customer2
        Customer customer2 = new Customer("12345678" ,"Jack Holloway" ,"100gatan" , "Male");
        Order order3 = new Order(1,getDate(),25.30,"Paid" );
        Order order4 = new Order(1,getDate(),12.99,"Not Paid" );
        customer2.addOrder(order3);
        customer2.addOrder(order4);
        customerList.add(customer2);

    }

    public String getDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void  Update(List<Customer> customersUpdated){
        customerList = customersUpdated;
    }

    public static DB getInstance(){
        if(DB_Instance==null){
            DB_Instance= new DB();
            DB_Instance.populateWithDummy();
        }
        return DB_Instance;
    }
}
