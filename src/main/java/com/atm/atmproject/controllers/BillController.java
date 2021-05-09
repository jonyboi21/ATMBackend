package com.atm.atmproject.controllers;

import com.atm.atmproject.models.Bill;
import com.atm.atmproject.repositories.AccountRepository;
import com.atm.atmproject.repositories.CustomerRepository;
import com.atm.atmproject.services.AccountService;
import com.atm.atmproject.services.BillService;
import com.atm.atmproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BillController {

    @Autowired
    private BillService billService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;


    //get all bills for specific account
    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.GET)
    public ResponseEntity<?> getAllBillsByAccountId(@PathVariable Long accountId) {
        Iterable<Bill> a = billService.getAllByAccountId(accountId);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    //get bill by id
    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.GET)
    public ResponseEntity<?> getBillById(@PathVariable Long billId) {
        Optional<Bill> b = billService.getById(billId);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    //get all bills by customer
    @RequestMapping(value = "/customers/{customerId}/bills", method = RequestMethod.GET)
    public ResponseEntity<?> getAllBillsByCustomerId(@PathVariable Long customerId) {
        Iterable<Bill> c = billService.getAllByCustomerId(customerId);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    // Update a Bill
    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateBill(@RequestBody Bill bill, @PathVariable Long billId) {
        billService.updateBill(bill, billId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Create A Bill
    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.POST)
    public ResponseEntity<?> createBill(@RequestBody Bill bill) {
        billService.createBill(bill);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // delete a bill
    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBill(@PathVariable Long billId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
