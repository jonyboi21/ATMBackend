package com.atm.atmproject.services;

import com.atm.atmproject.exception.ResourceNotFoundException;
import com.atm.atmproject.models.Account;
import com.atm.atmproject.repositories.AccountRepository;
import com.atm.atmproject.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;

    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    public Iterable<Account> getAllAccounts() {
        if(accountRepository.count() == 0){
            logger.info("NO ACCOUNTS EXIST");
            throw new ResourceNotFoundException("error fetching accounts");
        }
        logger.info("FOUND ALL ACCOUNTS");
        return accountRepository.findAll();
    }

    public Optional<Account> getById(Long accountId) {
        if (!(accountRepository.existsById(accountId))) {
            logger.info("ACCOUNT BY " + accountId + "DOES NOT EXIST");
            throw new ResourceNotFoundException("error fetching account");
        }
            logger.info("FOUND CUSTOMER ACCOUNT");
            return accountRepository.findById(accountId);
        }

    public Iterable<Account> getAllAccountsFromCustomer(Long customerId) {
        if (accountRepository.countAllByCustomerId(customerId) == 0) {
            logger.info("CUSTOMER DOES NOT HAVE ANY ACCOUNTS");
            throw new ResourceNotFoundException("error fetching customer accounts");
        }
        else if (!(customerRepository.existsById(customerId))){
            logger.info("CUSTOMER ACCOUNT BY ID OF "+ customerId + " DOES NOT EXIST");
            throw new ResourceNotFoundException("Customer account doesn't exist");
        }
            logger.info("FOUND CUSTOMER ACCOUNTS");
           return accountRepository.findAllByCustomerId(customerId);
    }

    public void createAccount(Account account, Long customerId) {
        if(!(customerRepository.existsById(customerId))){
            logger.info("CUSTOMER'S ACCOUNT DOES NOT EXIST");
            throw new ResourceNotFoundException("Error");
        }else
            account.setCustomerId(customerId);
            accountRepository.save(account);
            logger.info("SUCCESSFULLY CREATED CUSTOMER'S ACCOUNT");
        accountRepository.findAllByCustomerId(customerId);
    }

    public Account updateAccount(Long accountId, Account account) {
        if (!(accountRepository.existsById(account.getId()))) {
            logger.info("CANNOT UPDATE NON-EXISTING ACCOUNT");
            throw new ResourceNotFoundException("Error");
        } else {
            account.setId(accountId);
            accountRepository.save(account);
            logger.info("UPDATED CUSTOMER'S ACCOUNT");
            return account;
        }
    }

    public void deleteAccount(Long accountId) {
        if (!(accountRepository.existsById(accountId))) {
            logger.info("CANNOT DELETE NON-EXISTING ACCOUNT");
            throw new ResourceNotFoundException("Account does not exist");
        }else
        accountRepository.deleteById(accountId);
        logger.info("DELETED CUSTOMER'S ACCOUNT");
    }
}


