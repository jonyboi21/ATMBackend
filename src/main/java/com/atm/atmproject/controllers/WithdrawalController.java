package com.atm.atmproject.controllers;

import com.atm.atmproject.models.Account;
import com.atm.atmproject.models.Withdrawal;
import com.atm.atmproject.repositories.WithdrawalRepository;
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

//    @Autowired
//    AccountService accountService;
//
//    public void verifyAccount(Long accountId) throws ResourceNotFoundException {
//        Optional<Account> account = accountService.getAccount(accountId);
//        if (account.isEmpty()) {
//            throw new ResourceNotFoundException("Account with id " + accountId + " not found");
//        }
//    }

    //get all withdrawals from specific account

    //get withdrawal by id
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

    //delete a specific withdrawal
}
