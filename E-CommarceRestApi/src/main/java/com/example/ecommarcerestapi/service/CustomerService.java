package com.example.ecommarcerestapi.service;

import com.example.ecommarcerestapi.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer (Customer customer);
    List<Customer> gitAllCustomer ();
    Customer getCustomerByID(long id);
    Customer updateCustomer (Customer customer , long id);
    void deleteCustomer (long id);
}
