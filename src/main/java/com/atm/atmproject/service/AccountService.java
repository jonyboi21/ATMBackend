package com.atm.atmproject.service;

import com.atm.atmproject.models.Account;
import com.atm.atmproject.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Iterable<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Optional<Account> getById(Long accountId){
        return accountRepository.findById(accountId);
    }


}
