package com.atm.atmproject.controllers;

import com.atm.atmproject.models.Customer;
import com.atm.atmproject.repositories.CustomerRepository;
import com.atm.atmproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    //get all customers
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        customerService.getAllCustomers();
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    //get customer by Id
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerById (@PathVariable Long customerId) {
        customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customerRepository.findById(customerId), HttpStatus.OK);
    }


}
