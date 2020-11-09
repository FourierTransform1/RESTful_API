package com.hkr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hkr.Models.Customer;
import com.hkr.Models.Order;
import org.json.simple.JSONArray;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpHandler {

    Client client;
    String baseAddress;
    ObjectMapper objectMapper;

    public HttpHandler() {
        client = ClientBuilder.newClient();
        baseAddress = "http://localhost:8080/api/customers";
        objectMapper = new ObjectMapper();
        //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    }


    //gets all  the customers from the server
    public List<Customer> getAllCustomers() {
        String jsonResponse = client.target(baseAddress)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

        List<Customer> customers = null;
        try {
            customers = objectMapper.readValue(jsonResponse, new TypeReference<List<Customer>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customers;
    }

    //gets all  the customers from the server
    public Customer getCustomer(String SS) {
        WebTarget target = client.target(baseAddress).path("{customerID}");

        String jsonResponse = target.resolveTemplate("customerID", SS)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

        Customer customer = null;
        try {
            customer = objectMapper.readValue(jsonResponse, Customer.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customer;
    }

    //gets all  the orders of a specific customer from the server
    public List<Order> getOrders(String SS) {
        WebTarget target = client.target(baseAddress).path("{customerID}/orders");

        List<Order> orders = target.resolveTemplate("customerID", SS)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Order>>() {
                });

        return orders;
    }

    //updates the address of a customer and then returns same customer from server (to see the change)
    public Customer updateCustomer(String SS, Customer customer) {
        WebTarget target = client.target(baseAddress).path("{customerID}").path("/address");


        String response = target.resolveTemplate("customerID", SS)
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.json(customer)).readEntity(String.class);

        return getCustomer(SS);
    }

    //ends the running of the code
    public String exit() {
        if (client != null)
            client.close();
        return "connection closed!";
    }
}
