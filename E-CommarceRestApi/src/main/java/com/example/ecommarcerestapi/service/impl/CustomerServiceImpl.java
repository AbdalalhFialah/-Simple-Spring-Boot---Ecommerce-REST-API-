package com.example.ecommarcerestapi.service.impl;

import com.example.ecommarcerestapi.exception.ResourceNotFoundException;
import com.example.ecommarcerestapi.model.Customer;
import com.example.ecommarcerestapi.repository.CustomerRepository;
import com.example.ecommarcerestapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> gitAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByID(long id) {
       // Optional<Customer>customer = customerRepository.findById(id);
       // if (customer.isPresent())
      //      return customer.get();
     //   else
    //    throw new ResourceNotFoundException("Customer","ID",id);

         return customerRepository.findById(id).orElseThrow(()->  new ResourceNotFoundException("Customer","ID",id));
    }

    @Override
    public Customer updateCustomer(Customer customer, long id) {
        Customer exsitCustomer=  customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer","Id",id));

        exsitCustomer.setFirstName(customer.getFirstName());
        exsitCustomer.setLastName(customer.getLastName());
        exsitCustomer.setPhoneNumber(customer.getPhoneNumber());

        // Save Data
        customerRepository.save(exsitCustomer);
        return exsitCustomer;

    }

    @Override
    public void deleteCustomer(long id) {
        // Check if Id Custoemr is Found Or Not
        customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer","Id",id));
        customerRepository.deleteById(id);
    }
}
