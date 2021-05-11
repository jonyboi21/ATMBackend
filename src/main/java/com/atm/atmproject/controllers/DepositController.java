package com.atm.atmproject.controllers;

import com.atm.atmproject.exception.ResourceNotFoundException;
import com.atm.atmproject.models.*;
import com.atm.atmproject.repositories.AccountRepository;
import com.atm.atmproject.repositories.DepositRepository;
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
    private DepositRepository depositRepository;

    @Autowired
    private DepositService depositService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    public void verifyAccount(Long accountId) throws ResourceNotFoundException {
        Deposit deposit = new Deposit();
        Optional<Account> account = accountService.getById(accountId);
        if (account.isPresent()) { depositService.createDeposit(deposit);
        } else {
            throw new ResourceNotFoundException("Account not found");
        }
    }

    public void verifyDeposit(Long depositId) throws ResourceNotFoundException {
        Deposit deposit = new Deposit();
        Optional<Deposit> deposit1 = depositRepository.findById(depositId);
        if (deposit1.isEmpty()) {
            throw new ResourceNotFoundException("error fetching deposit with id: " + depositId);
        }
    }

    //    VerifyCreate
    public void verifyCreate(Long accountId) throws ResourceNotFoundException {
        Deposit deposit = new Deposit();
        Optional<Account> account = accountService.getById(accountId);
        if (account.isPresent()) { depositService.createDeposit(deposit);
        } else {
            throw new ResourceNotFoundException("Error creating deposit: Account not found");
        }
    }

    public void verifyUpdate(Long depositId) throws ResourceNotFoundException {
        Deposit deposit = new Deposit();
        Optional<Deposit> deposit1 = depositRepository.findById(depositId);
        if (deposit1.isEmpty()) {
            throw new ResourceNotFoundException("Deposit ID does not exist");
        }
    }

    public void verifyDelete(Long depositId) throws ResourceNotFoundException {
        Deposit deposit = new Deposit();
        Optional<Deposit> deposit1 = depositRepository.findById(depositId);
        if (deposit1.isEmpty()) {
            throw new ResourceNotFoundException("This id does not exist in deposits");
        }
    }

    //get all deposits from specific account
    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.GET)
    public ResponseEntity<?> getAllFromAccount(@PathVariable Long accountId) {
        verifyAccount(accountId);
        Iterable<Deposit> a = depositService.getAllByAccountId(accountId);
        SuccessfulResponseIterable successfulResponseIterable = new SuccessfulResponseIterable(HttpStatus.OK.value(), null, a);
        return new ResponseEntity<>(successfulResponseIterable, HttpStatus.OK);
    }

    //get deposit by id
    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.GET)
    public ResponseEntity<?> getDepositById(@PathVariable Long depositId) {
        verifyDeposit(depositId);
        Optional<Deposit> a = depositService.getById(depositId);
        SuccessfulResponseOptional successfulResponseOptional = new SuccessfulResponseOptional(HttpStatus.OK.value(), null, a);
        return new ResponseEntity<>(successfulResponseOptional, HttpStatus.OK);
    }

    //create a deposit
    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.POST)
    public ResponseEntity<?> createDeposit(@PathVariable Long accountId, @RequestBody Deposit deposit) {
        verifyCreate(accountId);
        depositService.createDeposit(deposit);
        SuccessfulResponseObject successfulResponseObject = new SuccessfulResponseObject(HttpStatus.CREATED.value(), "Created deposit and added it to the account", deposit);
        return new ResponseEntity<>(successfulResponseObject, HttpStatus.CREATED);
    }

    //update an existing deposit
    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateDeposit(@RequestBody Deposit deposit, @PathVariable Long depositId) {
        verifyUpdate(depositId);
        depositService.updateDeposit(deposit, depositId);
        SuccessfulResponseIterable successfulResponseIterable = new SuccessfulResponseIterable(202, "Accepted deposit modification");
        return new ResponseEntity<>(successfulResponseIterable, HttpStatus.OK);
    }

    //delete a specific deposit
    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDeposit(@PathVariable Long depositId) {
        verifyDelete(depositId);
        depositService.deleteDeposit(depositId);
        SuccessfulResponseIterable successfulResponseIterable = new SuccessfulResponseIterable(204, null);
        return new ResponseEntity<>(successfulResponseIterable, HttpStatus.OK);
    }
}
