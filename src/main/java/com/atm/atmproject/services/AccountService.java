package com.atm.atmproject.services;

import com.atm.atmproject.models.Account;
import com.atm.atmproject.repositories.AccountRepository;
import com.atm.atmproject.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;

    public Iterable<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Optional<Account> getById(Long accountId){
        return accountRepository.findById(accountId);
    }

//    public Iterable<Account> getAllAccountsFromCustomer(Long customerId){
//       return accountRepository.findAllAccountsByCustomer(customerId);
//    }
    public void createAccount(Account account, Long customerId){
        accountRepository.save(account);
    }

    public Account updateAccount(Long accountId, Account account){
        account.setId(accountId);
        accountRepository.save(account);
        return account;
    }


    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }


}
