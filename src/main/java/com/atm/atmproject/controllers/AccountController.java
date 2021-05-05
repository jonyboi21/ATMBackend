package com.atm.atmproject.controllers;

import com.atm.atmproject.models.Account;
import com.atm.atmproject.repositories.AccountRepository;
import com.atm.atmproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

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

    @RequestMapping(value = "/customers/{customerId}/accounts")
}
