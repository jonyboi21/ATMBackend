package com.atm.atmproject.controllers;
<<<<<<< HEAD
import com.atm.atmproject.models.Customer;
import com.atm.atmproject.models.SuccessfulResponse;
=======

import com.atm.atmproject.models.Customer;
import com.atm.atmproject.successfulresponse.SuccessfulResponseIterable;
import com.atm.atmproject.successfulresponse.SuccessfulResponseObject;
import com.atm.atmproject.successfulresponse.SuccessfulResponseOptional;
>>>>>>> 8bb954ab5be38a0a7b3c3111909fb7a161bf799c
import com.atm.atmproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {
<<<<<<< HEAD

=======
>>>>>>> 8bb954ab5be38a0a7b3c3111909fb7a161bf799c
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCustomers() {
<<<<<<< HEAD
        customerService.verifyCustomersInRepository();
        Iterable<Customer> getAllCustomers = customerService.getAllCustomers();
        SuccessfulResponse successfulResponse = new SuccessfulResponse(HttpStatus.OK.value(), "Success", customerService.getAllCustomers());
        return new ResponseEntity<Object>(successfulResponse, HttpStatus.OK);
=======
        SuccessfulResponseIterable successfulResponseIterable = new SuccessfulResponseIterable(HttpStatus.OK.value(), "Success", customerService.getAllCustomers());
        return new ResponseEntity<>(successfulResponseIterable, HttpStatus.OK);
>>>>>>> 8bb954ab5be38a0a7b3c3111909fb7a161bf799c
    }

    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerById(@PathVariable Long customerId) {
        customerService.verifyCustomer(customerId);
        Optional<Customer> getCustomerById = customerService.getCustomerById(customerId);
<<<<<<< HEAD
        SuccessfulResponse successfulResponse = new SuccessfulResponse(HttpStatus.OK.value(), "Success", getCustomerById);
        return new ResponseEntity<Object>(successfulResponse, HttpStatus.OK);
=======
        SuccessfulResponseOptional successfulResponseOptional = new SuccessfulResponseOptional(HttpStatus.OK.value(), "Success", getCustomerById);
        return new ResponseEntity<>(successfulResponseOptional, HttpStatus.OK);
>>>>>>> 8bb954ab5be38a0a7b3c3111909fb7a161bf799c
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public ResponseEntity<?> createCustomer(@Validated @RequestBody Customer customer) {
        customerService.createCustomer(customer);
<<<<<<< HEAD
        SuccessfulResponse successfulResponse = new SuccessfulResponse(HttpStatus.OK.value(), "Customer account updated", Optional.ofNullable(getCustomerById(customer.getCustomerId()).getBody()));
        return new ResponseEntity<Object>(successfulResponse, HttpStatus.CREATED);
=======
        SuccessfulResponseObject successfulResponseObject = new SuccessfulResponseObject(HttpStatus.OK.value(), "Customer account updated", customer);
        return new ResponseEntity<>(successfulResponseObject, HttpStatus.CREATED);
>>>>>>> 8bb954ab5be38a0a7b3c3111909fb7a161bf799c
    }

    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Long customerId) {
        customerService.updateCustomer(customer, customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
