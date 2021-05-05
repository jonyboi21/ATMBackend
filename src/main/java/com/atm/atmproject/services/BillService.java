package com.atm.atmproject.services;

import com.atm.atmproject.models.Bill;
import com.atm.atmproject.models.Customer;
import com.atm.atmproject.repositories.BillRepo;
import com.atm.atmproject.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepo billRepo;

    @Autowired
    private Customer customer;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    public void deleteBill(Long billId){
        billRepo.deleteById(billId);
    }

    public void createBill (Long billId, Bill bill) {
        billRepo.save(bill);
    }


    public void updateBill(Bill bill, Long billId) {
        // Save the entity
        billRepo.save(bill);
    }





}
