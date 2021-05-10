package com.atm.atmproject.services;

import com.atm.atmproject.exception.ResourceNotFoundException;
import com.atm.atmproject.models.Customer;
import com.atm.atmproject.models.SuccessfulResponse;
import com.atm.atmproject.models.SuccessfulResponseWrapper;
import com.atm.atmproject.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    //get all customers
    public Iterable<Customer> getAllCustomers() {
        if (customerRepository.findAll() == null) {
            throw new ResourceNotFoundException("error");
        } else {
            return customerRepository.findAll();
        }
    }

    //get a customer by Id
    public Optional<Customer> getCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    //create a customer
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    //update a customer
    public void updateCustomer(Customer customer, Long customerId) {
        customerRepository.save(customer);
    }

    //delete a customer
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }


    public void verifyCustomer(Long customerId) throws ResourceNotFoundException{
        if (!(customerRepository.existsById(customerId))) {
            throw new ResourceNotFoundException("Error fetching account");
        }
    }

    public void verifyCustomersInRepository() throws ResourceNotFoundException{
        Iterable<Customer> customer = getAllCustomers();
        if (!(customer.iterator().hasNext())) {
            throw new ResourceNotFoundException("Error fetching accounts");
        }
    }
}
