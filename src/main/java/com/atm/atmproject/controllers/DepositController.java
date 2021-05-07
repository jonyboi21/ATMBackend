package com.atm.atmproject.controllers;
import com.atm.atmproject.exception.ResourceNotFoundException;
import com.atm.atmproject.models.Account;
import com.atm.atmproject.models.Deposit;
import com.atm.atmproject.repositories.AccountRepository;
import com.atm.atmproject.services.AccountService;
import com.atm.atmproject.services.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DepositController {

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
    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.GET)
    public ResponseEntity<?> getAllFromAccount (@PathVariable Long accountId) {
        depositService.findAllByAccountId(accountId);
        return new ResponseEntity<>(depositService.getDepositById(accountId), HttpStatus.OK);
    }

    //get deposit by id
    @RequestMapping(value = "/desposits/{depositId}", method = RequestMethod.GET)
    public ResponseEntity<?> getDepositById (@PathVariable Long depositId) {
        depositService.getDepositById(depositId);
        return new ResponseEntity<>(depositService.getDepositById(depositId), HttpStatus.OK);
    }

    //create a deposit
    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.POST)
    public ResponseEntity<?> createDeposit (@PathVariable Long accountId, @RequestBody Deposit deposit) {
        verifyAccount(accountId);
        depositService.createDeposit(deposit);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //update an existing deposit
    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.PUT)
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
