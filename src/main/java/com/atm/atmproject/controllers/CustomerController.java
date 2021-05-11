package com.atm.atmproject.controllers;
import com.atm.atmproject.models.Customer;
import com.atm.atmproject.models.SuccessfulResponse;
import com.atm.atmproject.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {

    private static final Logger customerLogger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;


    //get all customers
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCustomers() {
        customerService.verifyCustomersInRepository();
        Iterable<Customer> getAllCustomers = customerService.getAllCustomers();
        SuccessfulResponse successfulResponse = new SuccessfulResponse(HttpStatus.OK.value(), "Success", customerService.getAllCustomers());
        customerLogger.info("SUCCESSFULLY RETRIEVED ALL CUSTOMERS");
        return new ResponseEntity<Object>(successfulResponse, HttpStatus.OK);
    }

    //get customer by Id
    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerById(@PathVariable Long customerId) {
        customerService.verifyCustomer(customerId);
        Optional<Customer> getCustomerById = customerService.getCustomerById(customerId);
        SuccessfulResponse successfulResponse = new SuccessfulResponse(HttpStatus.OK.value(), "Success", getCustomerById);
        customerLogger.info("SUCCESSFULLY RETRIEVED CUSTOMER WITH ID OF " + customerId);
        return new ResponseEntity<Object>(successfulResponse, HttpStatus.OK);
    }

    //create a customer
    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer(@Validated @RequestBody Customer customer) {
        customerService.createCustomer(customer);
        SuccessfulResponse successfulResponse = new SuccessfulResponse(HttpStatus.OK.value(), "Customer account updated", Optional.ofNullable(getCustomerById(customer.getCustomerId()).getBody()));
        customerLogger.info("CUSTOMER WITH ID OF " + customer.getCustomerId() + " SUCCESSFULLY CREATED");
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
