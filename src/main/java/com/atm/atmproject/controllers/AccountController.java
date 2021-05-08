package com.atm.atmproject.controllers;

import com.atm.atmproject.models.Account;
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

    @RequestMapping(value = "/accounts",method = RequestMethod.GET)
    public ResponseEntity<Iterable<Account>> getAllAccounts(){
    Iterable<Account> a = accountService.getAllAccounts();
    return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @RequestMapping(value = "/accounts/{accountId}",method = RequestMethod.GET)
    public ResponseEntity<?> getAccountById(@PathVariable Long accountId){
        Optional<Account> a = accountService.getById(accountId);
        return new ResponseEntity<> (a,HttpStatus.OK);
    }

    @RequestMapping(value = "/customers/{customerId}/accounts",method = RequestMethod.GET)
    public ResponseEntity<?> getAllAccountsFromCustomer(@PathVariable Long customerId){
        Iterable<Account> a = accountService.getAllAccountsFromCustomer(customerId);
        return new ResponseEntity<>(a,HttpStatus.OK);
    }


    @RequestMapping(value = "/customers/{customerId}/accounts",method = RequestMethod.POST)
    public ResponseEntity<?> createAnAccount(@RequestBody Account account, @PathVariable Long customerId ){
        accountService.createAccount(account,customerId);
            return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAnAccount(@RequestBody Account account,@PathVariable Long accountId){
       Account a = accountService.updateAccount(accountId,account);
        return new ResponseEntity<>(a,HttpStatus.OK);
    }
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSpecificAccount(@PathVariable Long accountId){
        accountService.deleteAccount(accountId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
