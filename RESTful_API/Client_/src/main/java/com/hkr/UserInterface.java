package com.hkr;
import org.codehaus.jackson.map.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.hkr.Models.Customer;
import com.hkr.Models.Order;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Filter;

public class UserInterface {

    HttpHandler postman = new HttpHandler();

    public void menu() {

        int choice;
        boolean flag=true;

        do{
            System.out.println("\n" +"1. Get all Customers" + "\n"
                    + "2. Get a specific Customer's Information"+ "\n"
                    + "3. Update a customer's Address"+ "\n"
                    + "4. Get a customer's orders" + "\n"
                    + "5: Exit"+ "\n");

            Scanner in = new Scanner(System.in);

            System.out.println("Choose (between 1-4): ");

            choice = Integer.parseInt(in.nextLine());

            switch(choice){

                case 1:
                    List<Customer> customers = postman.getAllCustomers();
                    System.out.println("Number of customers:" + customers.size());
                    for(Customer c : customers){ System.out.println(c.toString()); }
                    break;


                case 2:
                    System.out.println("Enter Customer SS: ");
                    String SS = in.nextLine();
                    Customer customer  = postman.getCustomer(SS);
                    System.out.println(customer.toString());
                    break;

                case 3:
                    System.out.println("Enter Customer SS: ");
                    Customer adrCustomer  = postman.getCustomer(in.nextLine());
                    System.out.println("Input New Address: ");
                    adrCustomer.setAddress(in.nextLine());
                    System.out.println(adrCustomer.getSS());
                    System.out.println(postman.updateCustomer(adrCustomer.getSS(), adrCustomer).toString());
                    break;

                case 4:
                    System.out.println("Input SS: ");
                    String ss = in.nextLine();
                    List<Order>orders = postman.getOrders(ss);
                    for(Order order: orders){ System.out.println(order.toString()); }
                    break;


                case 5:
                    String msg = postman.exit();
                    System.out.println(msg);
                    flag=false;
                    break;


                default:
                    //Complete
                    break;
            }
        }while(flag);


    }
}
