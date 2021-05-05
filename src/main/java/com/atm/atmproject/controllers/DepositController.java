package com.atm.atmproject.controllers;

import com.atm.atmproject.repositories.DepositRepository;
import com.atm.atmproject.services.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositController {

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private DepositService depositService;

    //get all deposits from specific account

    //get deposit by id

    //create a deposit

    //update an existing deposit

    //delete a specific deposit
}
