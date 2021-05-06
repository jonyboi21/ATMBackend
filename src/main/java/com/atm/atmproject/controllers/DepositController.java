package com.atm.atmproject.controllers;

import com.atm.atmproject.exception.ResourceNotFoundException;
import com.atm.atmproject.models.Account;
import com.atm.atmproject.models.Deposit;
import com.atm.atmproject.repositories.AccountRepository;
import com.atm.atmproject.repositories.DepositRepository;
import com.atm.atmproject.services.AccountService;
import com.atm.atmproject.services.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

@RestController
public class DepositController {

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private DepositService depositService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    //verify an account
    public void verifyAccount(Long accountId) throws ResourceNotFoundException {
        Optional<Account> account = accountService.getById(accountId);
        if (!(accountRepository.existsById(accountId))) {
            throw new ResourceNotFoundException("Account with id " + accountId + " not found");
        }
    }

    //get all deposits from specific account
//    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.GET)
//    public ResponseEntity<?> getAllDepositsFromAccount (@PathVariable Long accountId) {
//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(deposit.getId()).toUri());
//    }

    //get deposit by id
    @RequestMapping(value = "/desposits/{depositId}", method = RequestMethod.GET)
    public ResponseEntity<?> getDepositById (@PathVariable Long depositId) {
        depositService.getDepositById(depositId);
        return new ResponseEntity<>(depositRepository.findById(depositId), HttpStatus.OK);
    }

    //create a deposit
    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.POST)
    public ResponseEntity<?> createDeposit (@PathVariable Long accountId, @RequestBody Deposit deposit) {
        //verify this account
        depositService.createDeposit(deposit);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(deposit.getId()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //update an existing deposit
    @RequestMapping(value = "/deposits/{depositId", method = RequestMethod.PUT)
    public ResponseEntity<?> updateDeposit(@RequestBody Deposit deposit, @PathVariable Long depositId) {
        depositService.updateDeposit(deposit, depositId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //delete a specific deposit
    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDeposit (@PathVariable Long depositId) {
        depositService.deleteDeposit(depositId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
