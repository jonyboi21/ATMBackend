package com.atm.atmproject.services;

import com.atm.atmproject.exception.ResourceNotFoundException;
import com.atm.atmproject.models.Customer;
import com.atm.atmproject.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository customerRepository;

    public Iterable<Customer> getAllCustomers() {
        if (!(customerRepository.findAll().iterator().hasNext())) {
            logger.info("FAILED TO RETRIEVE ALL CUSTOMERS");
            throw new ResourceNotFoundException("Error fetching accounts");
        } else {
            logger.info("SUCCESSFULLY RETRIEVED ALL CUSTOMERS");
            return customerRepository.findAll();
        }
    }

    public Optional<Customer> getCustomerById(Long customerId) {
        logger.info("SUCCESSFULLY RETRIEVED CUSTOMER WITH ID OF " + customerId);
        return customerRepository.findById(customerId);
    }

    public void createCustomer(Customer customer) {
        logger.info("CUSTOMER SUCCESSFULLY CREATED");
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer, Long customerId) {
        logger.info("CUSTOMER ACCOUNT FOR CUSTOMER " + customer.getCustomerId() + " SUCCESSFULLY UPDATED");
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long customerId) {
        logger.info("CUSTOMER " + customerId + " REMOVED FROM SYSTEM");
        customerRepository.deleteById(customerId);
    }

    public void verifyCustomer(Long customerId) throws ResourceNotFoundException {
        if (!(customerRepository.existsById(customerId))) {
            throw new ResourceNotFoundException("Error fetching account");
        }
    }
}
