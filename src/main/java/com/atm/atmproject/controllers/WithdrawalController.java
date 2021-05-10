package com.atm.atmproject.controllers;

import com.atm.atmproject.exception.ResourceNotFoundException;
import com.atm.atmproject.models.*;
import com.atm.atmproject.repositories.AccountRepository;
import com.atm.atmproject.repositories.WithdrawalRepository;
import com.atm.atmproject.services.AccountService;
import com.atm.atmproject.services.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class WithdrawalController {

    @Autowired
    AccountService accountService;
    @Autowired
    private WithdrawalService withdrawalService;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private WithdrawalRepository withdrawalRepository;

    public void verifyAccount(Long accountId) throws ResourceNotFoundException {
        Withdrawal withdrawal = new Withdrawal();
        Optional<Account> account = accountService.getById(accountId);
        if (account.isPresent()) { withdrawalService.createWithdrawal(withdrawal);
        } else {
            throw new ResourceNotFoundException("Account not found");
        }
    }

    public void verifyWithdrawal(Long withdrawalId) throws ResourceNotFoundException {
        Withdrawal withdrawal = new Withdrawal();
        Optional<Withdrawal> withdrawal1 = withdrawalRepository.findById(withdrawalId);
        if (withdrawal1.isEmpty()) {
            throw new ResourceNotFoundException("error fetching withdrawal with id: " + withdrawalId);
        }
    }

    //    VerifyCreate
    public void verifyCreate(Long accountId) throws ResourceNotFoundException {
        Withdrawal withdrawal = new Withdrawal();
        Optional<Account> account = accountService.getById(accountId);
        if (account.isPresent()) { withdrawalService.createWithdrawal(withdrawal);
        } else {
            throw new ResourceNotFoundException("Error creating withdrawal: Account not found");
        }
    }

    public void verifyUpdate(Long withdrawalId) throws ResourceNotFoundException {
        Withdrawal withdrawal = new Withdrawal();
        Optional<Withdrawal> withdrawal1 = withdrawalRepository.findById(withdrawalId);
        if (withdrawal1.isEmpty()) {
            throw new ResourceNotFoundException("Withdrawal ID does not exist");
        }
    }

    public void verifyDelete(Long withdrawalId) throws ResourceNotFoundException {
        Withdrawal withdrawal = new Withdrawal();
        Optional<Withdrawal> withdrawal1 = withdrawalRepository.findById(withdrawalId);
        if (withdrawal1.isEmpty()) {
            throw new ResourceNotFoundException("This id does not exist in withdrawals");
        }
    }

    //get all withdrawals for a specific account
    @RequestMapping(value = "/accounts/{accountId}/withdrawals", method = RequestMethod.GET)
    public ResponseEntity<?> findAllByAccountId(@PathVariable Long accountId) {
        verifyAccount(accountId);
        Iterable<Withdrawal> a = withdrawalService.getAllByAccountId(accountId);
        SuccessfulResponse successfulResponse = new SuccessfulResponse(HttpStatus.OK.value(), null, a);
        return new ResponseEntity<>(successfulResponse, HttpStatus.OK);
    }

    //get withdrawal by id
    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.GET)
    public ResponseEntity<?> getWithdrawal(@PathVariable Long withdrawalId) {
        verifyWithdrawal(withdrawalId);
        Optional<Withdrawal> a = withdrawalService.getWithdrawal(withdrawalId);
        SuccessfulResponse successfulResponse = new SuccessfulResponse(HttpStatus.OK.value(), null, a);
        return new ResponseEntity<>(successfulResponse, HttpStatus.OK);
    }

    //create a withdrawal
    @RequestMapping(value = "/accounts/{accountId}/withdrawals", method = RequestMethod.POST)
    public ResponseEntity<?> createWithdrawal(@PathVariable Long accountId, @RequestBody Withdrawal withdrawal) {
        verifyCreate(accountId);
        withdrawalService.createWithdrawal(withdrawal);
        //SuccessfulResponse successfulResponse = new SuccessfulResponse(HttpStatus.OK.value(), "Created withdrawal and deducted it from the account", withdrawalService.createWithdrawal(withdrawal));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //update an existing withdrawal
    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateWithdrawal(@RequestBody Withdrawal withdrawal, @PathVariable Long withdrawalId) {
        verifyUpdate(withdrawalId);
        withdrawalService.updateWithdrawal(withdrawal, withdrawalId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //delete a specific withdrawal
    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteWithdrawal(@PathVariable Long withdrawalId) {
        verifyDelete(withdrawalId);
        withdrawalService.deleteWithdrawal(withdrawalId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
