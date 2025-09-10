package LLDQues.RestaurantManagementSystem.service;

import LLDQues.RestaurantManagementSystem.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomerService {
    private Map<Integer, Customer> customers;
    private AtomicInteger customerIdGenerator;

    public CustomerService(){
        this.customers = new ConcurrentHashMap<>();
        this.customerIdGenerator = new AtomicInteger(1);
    }


    public Customer registerCustomer(String name, String phoneNumber, String email){
        int customerId = customerIdGenerator.getAndIncrement();
        Customer customer = new Customer(customerId, name, phoneNumber, email);
        customers.put(customerId, customer);
        return customer;
    }

    public Customer getCustomer(int id){

        return customers.get(id);
    }

    public List<Customer> getAllCustomers(){
        List<Customer> customerList = new ArrayList<>();
        for (Customer customer: customers.values()) {
            customerList.add(customer);
        }
        return customerList;
    }





}
