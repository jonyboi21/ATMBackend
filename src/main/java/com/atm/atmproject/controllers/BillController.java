package com.atm.atmproject.controllers;

import com.atm.atmproject.models.Account;
import com.atm.atmproject.models.Bill;
import com.atm.atmproject.models.Customer;
import com.atm.atmproject.repositories.AccountRepository;
import com.atm.atmproject.repositories.BillRepo;
import com.atm.atmproject.repositories.CustomerRepository;
import com.atm.atmproject.services.AccountService;
import com.atm.atmproject.services.BillService;
import com.atm.atmproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

@RestController
public class BillController {

    @Autowired
    private BillService billService;

    @Autowired
    private BillRepo billRepo;

    @Autowired
    private Account account;

    @Autowired
    private Customer customer;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;



//Get Bills By ID
    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.GET)
    public ResponseEntity<?> getBillByBillId (@PathVariable Long billId) {
        return new ResponseEntity<>(billRepo.findById(billId), HttpStatus.OK);
    }

    // Delete a Bill
    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteVote(@PathVariable Long billId){
    billService.deleteBill(billId);
    return new ResponseEntity<>(HttpStatus.OK);
}

    // Update a Bill
    @RequestMapping(value="/bills/{billId}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateBill(@RequestBody Bill bill, @PathVariable Long billId) {
    billService.updateBill(bill,billId);
     return new ResponseEntity<>(HttpStatus.OK);
}

// Create A Bill
    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.POST)
    public ResponseEntity<?> createVote (@RequestBody Bill bill) {

    billService.createBill(bill);
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}").buildAndExpand(bill.getId()).toUri());
    return new ResponseEntity<>(HttpStatus.CREATED);
}

// Get Bill by Customer Id.
@RequestMapping(value="/customers/{customerId}/bills", method=RequestMethod.GET)
public Optional<Bill> getBillsByCustomerId(@PathVariable Long customerId) {

    return billService.getAllBillsCusID(customerId);
}

// Get Bill by Account Id.
@RequestMapping(value="/accounts/{accountId}/bills", method=RequestMethod.GET)
public Optional<Bill> getBillsByAccountId(@PathVariable Long accountId) {

    return billService.getAllBillsAccID(accountId);
}



}
