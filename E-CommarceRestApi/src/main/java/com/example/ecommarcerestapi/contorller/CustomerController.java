package com.example.ecommarcerestapi.contorller;

import com.example.ecommarcerestapi.model.Customer;
import com.example.ecommarcerestapi.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }



    // Build Creat Customer REST API
    @PostMapping
    public ResponseEntity<Customer> saveCustomer (@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);

    }
    // Build Get All Customer
    @GetMapping
    public List<Customer>gitAllCustomer (){
        return customerService.gitAllCustomer();
    }
    // http://localhost:8082/api/customer/1
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById (@PathVariable("id") long customerId){
        return new ResponseEntity<>(customerService.getCustomerByID(customerId),HttpStatus.OK);
    }
    // Build Update Customer REST API
    // http://localhost:8082/api/customer/1
    @PutMapping("{id}")
    public ResponseEntity<Customer>updateCustomer (@PathVariable("id") long customerId ,@RequestBody Customer customer){

        return new ResponseEntity<>(customerService.updateCustomer(customer,customerId),HttpStatus.OK);

    }
    // Build Delete Customer REST API
    @DeleteMapping("{id}")
    public  ResponseEntity<String>deleteCustomer (@PathVariable("id") long customerId){
        customerService.deleteCustomer(customerId);
        return  new ResponseEntity<>("Customer Delete Successful",HttpStatus.OK);

    }


}
