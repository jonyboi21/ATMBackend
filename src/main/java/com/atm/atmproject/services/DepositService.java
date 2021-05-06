package com.atm.atmproject.services;

import com.atm.atmproject.models.Deposit;
import com.atm.atmproject.repositories.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositService {

    @Autowired
    private DepositRepository depositRepository;

    //get all deposits from a specific account
//    public Iterable<Deposit> getAllDepositsFromAccount(Long depositId) {
//        depositRepository.findAllById(dep
//    }

    //get a deposit by Id
    public void getDepositById(Long depositId) {
        depositRepository.findById(depositId);
    }

    //create a deposit
    public void createDeposit(Deposit deposit) {
        depositRepository.save(deposit);
    }

    //update a deposit
    public void updateDeposit(Deposit deposit, Long depositId) {
        deposit.setId(depositId);
        depositRepository.save(deposit);
    }

    //delete a deposit
    public void deleteDeposit(Long depositId) {
        depositRepository.deleteById(depositId);
    }
}
