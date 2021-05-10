package com.atm.atmproject.services;

import com.atm.atmproject.controllers.BillController;
import com.atm.atmproject.exception.ResourceNotFoundException;
import com.atm.atmproject.models.Bill;
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
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BillController billController;



    //get all bills for specific account
    public Iterable<Bill> getAllByAccountId(Long accountId) {

            return billRepo.getAllBillsByAccountId(accountId);


    }

    //get all bills by customer
    public Iterable<Bill> getAllByCustomerId(Long customerId) {

            return billRepo.getAllBillsByCustomerId(customerId);

    }


    //get bill by Id
    public Optional<Bill> getById(Long billId) {

                return billRepo.findById(billId);
    }

    // Create Bill
    public void createBill(Bill bill) {
        billRepo.save(bill);
    }

    // Update Bill
    public void updateBill(Bill bill, Long billId) {
        // Save the entity
        billRepo.save(bill);
    }

    //delete a bill
    public void deleteBill(Long billId) {
        billRepo.deleteById(billId);
    }
}
