package com.api.resources;
import com.api.Services.CustomerServices;
import com.api.models.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

    CustomerServices services = new CustomerServices();


    @GET
    public List<Customer> customers(){
        return services.getCustomers();
    }


    @GET
    @Path("/{customerID}")
    public Customer getCustomer(@PathParam("customerID")String ss){
        return services.getCustomer(ss);
    }



    @GET
    @Path("/{customerID}/orders")
    public List<Order> getCustomerOrders(@PathParam("customerID")String ss){
        return services.getOrders(ss);
    }



    @PUT
    @Path("/{customerID}/address")
    public Customer updateCustomerAddress(@PathParam("customerID")String ss, Customer customer){
        return services.updateAddress(ss, customer);
    }


}