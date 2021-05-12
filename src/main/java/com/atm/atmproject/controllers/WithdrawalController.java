package com.atm.atmproject.controllers;

import com.atm.atmproject.exception.ResourceNotFoundException;
import com.atm.atmproject.models.*;
import com.atm.atmproject.repositories.AccountRepository;
import com.atm.atmproject.repositories.WithdrawalRepository;
import com.atm.atmproject.services.AccountService;
import com.atm.atmproject.services.WithdrawalService;
import com.atm.atmproject.successfulresponse.SuccessfulResponseIterable;
import com.atm.atmproject.successfulresponse.SuccessfulResponseObject;
import com.atm.atmproject.successfulresponse.SuccessfulResponseOptional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class WithdrawalController {

    private static final Logger logger = LoggerFactory.getLogger(WithdrawalController.class);

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
        if (!account.isPresent()) {
            throw new ResourceNotFoundException("Account not found");
        }
    }

    public void verifyWithdrawal(Long withdrawalId) throws ResourceNotFoundException {
        Withdrawal withdrawal = new Withdrawal();
        Optional<Withdrawal> withdrawal1 = withdrawalRepository.findById(withdrawalId);
        if (withdrawal1.isEmpty()) {
            logger.info("ERROR FETCHING WITHDRAWAL WITH ID: " + withdrawalId);
            throw new ResourceNotFoundException("error fetching withdrawal with id: " + withdrawalId);
        }
    }

    public void verifyCreate(Long accountId) throws ResourceNotFoundException {
        Withdrawal withdrawal = new Withdrawal();
        Optional<Account> account = accountService.getById(accountId);
        if (!account.isPresent()) {
            logger.info("ERROR CREATING WITHDRAWAl");
            throw new ResourceNotFoundException("Error creating withdrawal: Account not found");
        }
    }

    public void verifyUpdate(Long withdrawalId) throws ResourceNotFoundException {
        Withdrawal withdrawal = new Withdrawal();
        Optional<Withdrawal> withdrawal1 = withdrawalRepository.findById(withdrawalId);
        if (withdrawal1.isEmpty()) {
            logger.info("ERROR UPDATING WITHDRAWAL WITH ID: " + withdrawalId);
            throw new ResourceNotFoundException("Withdrawal ID does not exist");
        }
    }

    public void verifyDelete(Long withdrawalId) throws ResourceNotFoundException {
        Withdrawal withdrawal = new Withdrawal();
        Optional<Withdrawal> withdrawal1 = withdrawalRepository.findById(withdrawalId);
        if (withdrawal1.isEmpty()) {
            logger.info("ERROR DELETING WITHDRAWAL ID: " + withdrawalId);
            throw new ResourceNotFoundException("This id does not exist in withdrawals");
        }
    }

    @RequestMapping(value = "/accounts/{accountId}/withdrawals", method = RequestMethod.GET)
    public ResponseEntity<?> findAllByAccountId(@PathVariable Long accountId) {
        verifyAccount(accountId);
        Iterable<Withdrawal> a = withdrawalService.getAllByAccountId(accountId);
        SuccessfulResponseIterable successfulResponseIterable = new SuccessfulResponseIterable(HttpStatus.OK.value(), null, a);
        return new ResponseEntity<>(successfulResponseIterable, HttpStatus.OK);
    }

    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.GET)
    public ResponseEntity<?> getWithdrawal(@PathVariable Long withdrawalId) {
        verifyWithdrawal(withdrawalId);
        Optional<Withdrawal> a = withdrawalService.getWithdrawal(withdrawalId);
        SuccessfulResponseOptional successfulResponseOptional = new SuccessfulResponseOptional(HttpStatus.OK.value(), null, a);
        return new ResponseEntity<>(successfulResponseOptional, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}/withdrawals", method = RequestMethod.POST)
    public ResponseEntity<?> createWithdrawal(@PathVariable Long accountId,@Validated @RequestBody Withdrawal withdrawal) {
        verifyCreate(accountId);
        withdrawalService.createWithdrawal(withdrawal);
        SuccessfulResponseObject successfulResponseObject = new SuccessfulResponseObject(HttpStatus.CREATED.value(), "Created withdrawal and deducted it from the account", withdrawal);
        return new ResponseEntity<>(successfulResponseObject, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateWithdrawal(@RequestBody Withdrawal withdrawal, @PathVariable Long withdrawalId) {
        verifyUpdate(withdrawalId);
        withdrawalService.updateWithdrawal(withdrawal, withdrawalId);
        SuccessfulResponseIterable successfulResponseIterable = new SuccessfulResponseIterable(202, "Accepted withdrawal modification");
        return new ResponseEntity<>(successfulResponseIterable, HttpStatus.OK);
    }

    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteWithdrawal(@PathVariable Long withdrawalId) {
        verifyDelete(withdrawalId);
        withdrawalService.deleteWithdrawal(withdrawalId);
        SuccessfulResponseIterable successfulResponseIterable = new SuccessfulResponseIterable(204, null);
        return new ResponseEntity<>(successfulResponseIterable, HttpStatus.OK);
    }
}
