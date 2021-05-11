package com.atm.atmproject.controllers;

import com.atm.atmproject.models.Account;
import com.atm.atmproject.models.SuccessfulResponseIterable;
import com.atm.atmproject.models.SuccessfulResponseObject;
import com.atm.atmproject.models.SuccessfulResponseOptional;
import com.atm.atmproject.repositories.CustomerRepository;
import com.atm.atmproject.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AccountController {


    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Account>> getAllAccounts() {
        Iterable<Account> a = accountService.getAllAccounts();
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    public ResponseEntity<?> getAccountById(@PathVariable Long accountId) {
        Optional<Account> a = accountService.getById(accountId);
        SuccessfulResponseOptional successfulResponseIterable = new SuccessfulResponseOptional(HttpStatus.OK.value(), "Success",a);
        return new ResponseEntity<>(successfulResponseIterable, HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAccountsFromCustomer(@PathVariable Long customerId) {
        Iterable<Account> a = accountService.getAllAccountsFromCustomer(customerId);
        SuccessfulResponseIterable successfulResponseIterable = new SuccessfulResponseIterable(HttpStatus.OK.value(),"Success",a);
        return new ResponseEntity<>(successfulResponseIterable, HttpStatus.OK);
    }


    @RequestMapping(value = "/customers/{customerId}/accounts", method = RequestMethod.POST)
    public ResponseEntity<?> createAnAccount(@RequestBody Account account, @PathVariable Long customerId) {
        accountService.createAccount(account, customerId);
        SuccessfulResponseObject successfulResponseObject = new SuccessfulResponseObject(HttpStatus.OK.value(),"Account created", (Iterable<?>) account);
        return new ResponseEntity<>(successfulResponseObject,HttpStatus.CREATED);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAnAccount(@RequestBody Account account, @PathVariable Long accountId) {
        Account a = accountService.updateAccount(accountId, account);
        SuccessfulResponseIterable successfulResponseIterable = new SuccessfulResponseIterable(HttpStatus.OK.value(), "Customer account updated");
        return new ResponseEntity<>(successfulResponseIterable, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSpecificAccount(@PathVariable Long accountId) {
        accountService.deleteAccount(accountId);
        SuccessfulResponseIterable successfulResponseIterable = new SuccessfulResponseIterable(HttpStatus.OK.value(),"Account successfully deleted");
        return new ResponseEntity<>(successfulResponseIterable,HttpStatus.OK);
    }

}
