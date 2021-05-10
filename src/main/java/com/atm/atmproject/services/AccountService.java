package com.atm.atmproject.services;

import com.atm.atmproject.exception.ResourceNotFoundException;
import com.atm.atmproject.models.Account;
import com.atm.atmproject.repositories.AccountRepository;
import com.atm.atmproject.repositories.CustomerRepository;
import com.sun.istack.NotNull;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;

    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getById(Long accountId){
        if (!(accountRepository.existsById(accountId))) {
            throw new ResourceNotFoundException("error fetching account");
        }
        else {
            return accountRepository.findById(accountId);
        }
    }

    public Iterable<Account> getAllAccountsFromCustomer(Long customerId) {
        if (accountRepository.countAllByCustomerId(customerId) == 0) {
            throw new ResourceNotFoundException("error fetching customer accounts");
        }
           return accountRepository.findAllByCustomerId(customerId);
    }

    public void createAccount(Account account, Long customerId) {
            account.setCustomerId(customerId);
            accountRepository.save(account);
    }

    public Account updateAccount(Long accountId, Account account) {
        if (!(accountRepository.existsById(account.getId()))) {
            throw new ResourceNotFoundException("Error");
        } else {
            account.setId(accountId);
            accountRepository.save(account);
            return account;
        }
    }


    public void deleteAccount(Long accountId) {
        if(!(accountRepository.existsById(accountId))){
            throw new ResourceNotFoundException("Account does not exist");
        }else
        accountRepository.deleteById(accountId);
    }



}


