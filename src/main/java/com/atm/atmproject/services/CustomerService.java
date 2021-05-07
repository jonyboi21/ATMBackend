package com.atm.atmproject.services;

import com.atm.atmproject.models.Customer;
import com.atm.atmproject.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    //get all customers
    public Iterable<Customer> getAllCustomers() {
       return customerRepository.findAll();
    }

    //get a customer by Id
    public void getCustomerById(Long customerId) {
        customerRepository.findById(customerId);
    }

    //create a customer
    public void createCustomer(Customer customer) {
        customer = customerRepository.save(customer);
    }

    //update a customer
    public void updateCustomer(Customer customer, Long customerId) {
        customerRepository.save(customer);
    }

    //delete a customer
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
