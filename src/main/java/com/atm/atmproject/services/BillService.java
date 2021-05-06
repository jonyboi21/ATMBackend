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


//    Get all Bills
    public void getAllBills( ){
        billRepo.findAll();
    }

    //    Delete Bill
    public void deleteBill(Long billId){
        billRepo.deleteById(billId);
    }

    // Create Bill
    public void createBill (Bill bill) {
        billRepo.save(bill);
    }

    // Update Bill
    public void updateBill(Bill bill, Long billId) {
        // Save the entity
        billRepo.save(bill);
    }

//    Get all bills by customer id
    public Optional<Bill> getAllBillsCusID(Long customerID) {
        return billRepo.findById(customerID);
    }

//    Get all Bills by account id
public Optional<Bill> getAllBillsAccID(Long accountId) {
    return billRepo.findById(accountId);
}


}
