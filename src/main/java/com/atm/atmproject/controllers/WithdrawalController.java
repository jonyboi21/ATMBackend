package com.atm.atmproject.controllers;

import com.atm.atmproject.exception.ResourceNotFoundException;
import com.atm.atmproject.models.Account;
import com.atm.atmproject.models.Withdrawal;
import com.atm.atmproject.repositories.AccountRepository;
import com.atm.atmproject.repositories.WithdrawalRepository;
import com.atm.atmproject.services.AccountService;
import com.atm.atmproject.services.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

@RestController
public class WithdrawalController {

    @Autowired
    private WithdrawalRepository withdrawalRepository;

    @Autowired
    private WithdrawalService withdrawalService;


    @Autowired
    AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    public void verifyAccount(Long accountId) throws ResourceNotFoundException {
        Optional<Account> account = accountService.getById(accountId);
        if (!(accountRepository.existsById(accountId))) {
            throw new ResourceNotFoundException("Account with id " + accountId + " not found");
        }
    }

    @RequestMapping(value = "/accounts/{accountId}/withdrawal",method = RequestMethod.GET)
    public ResponseEntity<?> findAllWithdrawalsByAccountId(@PathVariable Long accountId){
        Iterable<Withdrawal> a = withdrawalService.findAllWithdrawalsByAccountId(accountId);
        return new ResponseEntity<>(a,HttpStatus.OK);
    }


    //get withdrawal by id
    @RequestMapping(value="/withdrawals/{withdrawalId}", method=RequestMethod.GET)
    public ResponseEntity<?> getWithdrawal(@PathVariable Long withdrawalId) {
        withdrawalService.getWithdrawal(withdrawalId);
        return new ResponseEntity<>(withdrawalRepository.findById(withdrawalId), HttpStatus.OK);
    }

    //create a withdrawal
    @RequestMapping(value = "/accounts/{accountId}/withdrawals", method = RequestMethod.POST)
    public ResponseEntity<?> createWithdrawal (@PathVariable Long accountId, @RequestBody Withdrawal withdrawal) {
        verifyAccount(accountId);
        withdrawalService.createWithdrawal(withdrawal);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(withdrawal.getId()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @RequestMapping(value="/polls/{pollId}", method=RequestMethod.GET)
//    public ResponseEntity<?> getPoll(@PathVariable Long withdrawalId) {
//        verifyAccount();
//        withdrawalService.getWithdrawal(withdrawalId);
//        return new ResponseEntity<>(withdrawalRepository.findById(withdrawalId), HttpStatus.OK);
//    }
//
//    //create a withdrawal
//    @RequestMapping(value = "/accounts/{accountId}/withdrawals", method = RequestMethod.POST)
//    public ResponseEntity<?> createWithdrawal (@PathVariable Long accountId, @RequestBody Withdrawal withdrawal) {
//        verifyAccount(accountId);
//        withdrawalService.createWithdrawal(accountId, withdrawal);
//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(withdrawal.getId()).toUri());
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
    //update an existing withdrawal
    @RequestMapping(value="/withdrawals/{withdrawalId}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateWithdrawal(@RequestBody Withdrawal withdrawal, @PathVariable Long withdrawalId) {
        withdrawalService.updateWithdrawal(withdrawal, withdrawalId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //delete a specific withdrawal
    @RequestMapping(value = "/withdrawals/{withdrawalId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteWithdrawal(@PathVariable Long withdrawalId){
        withdrawalService.deleteWithdrawal(withdrawalId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
