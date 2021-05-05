package com.atm.atmproject.controllers;

import com.atm.atmproject.models.Account;
import com.atm.atmproject.models.Bill;
import com.atm.atmproject.models.Customer;
import com.atm.atmproject.repositories.BillRepo;
import com.atm.atmproject.repositories.CustomerRepository;
import com.atm.atmproject.services.BillService;
import com.atm.atmproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class BillController {

    @Autowired
    private BillService billService;

    private BillRepo billRepo;

    @Autowired
    private Account account;

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRepository customerRepository;




//Get Bills By ID
    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.GET)
    public ResponseEntity<?> getBillById (@PathVariable Long billId) {
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





}
