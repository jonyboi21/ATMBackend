package com.atm.atmproject.controllers;

import com.atm.atmproject.models.Customer;
import com.atm.atmproject.models.SuccessfulResponseIterable;
import com.atm.atmproject.models.SuccessfulResponseWrapper;
import com.atm.atmproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {

    private SuccessfulResponseIterable successfulResponseIterable;

    private SuccessfulResponseWrapper successfulResponseWrapper;

    @Autowired
    private CustomerService customerService;


    //get all customers
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCustomers() {
        customerService.verifyCustomersInRepository();
        Iterable<Customer> getAllCustomers = customerService.getAllCustomers();
        SuccessfulResponseIterable successfulResponseIterable = new SuccessfulResponseIterable(HttpStatus.OK.value(), "Success", customerService.getAllCustomers());
        return new ResponseEntity<Object>(successfulResponseIterable, HttpStatus.OK);
    }

    //get customer by Id
    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerById(@PathVariable Long customerId) {
        customerService.verifyCustomer(customerId);
        Optional<Customer> getCustomerById = customerService.getCustomerById(customerId);
        SuccessfulResponse successfulResponse = new SuccessfulResponse(HttpStatus.OK.value(), "Success", getCustomerById);
        return new ResponseEntity<Object>(successfulResponse, HttpStatus.OK);
    }

    //create a customer
    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer(@Validated @RequestBody Customer customer, @PathVariable Long customerId) {
        customerService.createCustomer(customer);
        SuccessfulResponse successfulResponse = new SuccessfulResponse(HttpStatus.OK.value(), "Customer account updated", customerService.getCustomerById(customerId));
        return new ResponseEntity<Object>(successfulResponse, HttpStatus.CREATED);
    }

    //update a customer
    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Long customerId) {
        customerService.updateCustomer(customer, customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //delete a customer
    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
