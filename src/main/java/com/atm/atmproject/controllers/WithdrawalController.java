package com.atm.atmproject.controllers;

import com.atm.atmproject.repositories.WithdrawalRepository;
import com.atm.atmproject.services.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WithdrawalController {

    @Autowired
    private WithdrawalRepository withdrawalRepository;

    @Autowired
    private WithdrawalService withdrawalService;

    //get all withdrawals from specific account

    //get withdrawal by id

    //create a withdrawal

    //update an existing withdrawal

    //delete a specific withdrawal
}
