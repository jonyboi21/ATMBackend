package com.atm.atmproject.controllers;

import com.atm.atmproject.repositories.DepositRepository;
import com.atm.atmproject.services.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositController {

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private DepositService depositService;

    //get all deposits from specific account

    //get deposit by id
    @RequestMapping(value = "/desposits/{depositId}", method = RequestMethod.GET)
    public ResponseEntity<?> getDepositById (@PathVariable Long depositId) {
        depositService.getDepositById(depositId);
        return new ResponseEntity<>(depositRepository.findById(depositId), HttpStatus.OK);
    }

//    //create a deposit
//    @RequestMapping(value = )

    //update an existing deposit

    //delete a specific deposit
}
