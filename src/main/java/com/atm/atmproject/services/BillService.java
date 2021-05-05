package com.atm.atmproject.services;

import com.atm.atmproject.models.Bill;
import com.atm.atmproject.models.Customer;
import com.atm.atmproject.repositories.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepo billRepo;

    @Autowired
    private Customer customer;

//    Get All Bills by customer by id
    public void getABillsByCustomerId(){
        Iterable<Customer>
    }



}
