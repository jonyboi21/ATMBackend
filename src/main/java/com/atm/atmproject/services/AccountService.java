package com.atm.atmproject.services;

import com.atm.atmproject.models.Account;
import com.atm.atmproject.models.Customer;
import com.atm.atmproject.repositories.AccountRepository;
import com.atm.atmproject.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

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

    public Iterable<Account> getAllAccountsFromCustomer(Long customerId){
       return customerRepository
               .findById(customerId)
               .get()
               .getAccounts();

    }
    public void createAccount(Account account, Long customerId){
        customerRepository
                .findById(customerId)
                .get()
                .getAccounts()
                .add(account);
    }
    public void updateAccount(Long accountId, Account account){
        accountRepository
                .findById(accountId).get().


        //       Optional<Customer> a = customerRepository.findById(accoundId);
//       a.ifPresent(x->x.se(account));
    }

    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }
}
