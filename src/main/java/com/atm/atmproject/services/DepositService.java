package com.atm.atmproject.services;

import com.atm.atmproject.models.Deposit;
import com.atm.atmproject.repositories.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepositService {

    @Autowired
    private DepositRepository depositRepository;

    public Iterable<Deposit> getAllByAccountId(Long accountId) {
        return depositRepository.findAllByAccountId(accountId);
    }

    //get a deposit by Id
    public Optional<Deposit> getById(Long depositId) {
        return depositRepository.findById(depositId);
    }

    //create a deposit
    public void createDeposit(Deposit deposit) {
        depositRepository.save(deposit);
    }

    //update a deposit
    public void updateDeposit(Deposit deposit, Long depositId) {
        depositRepository.save(deposit);
    }

    //delete a deposit
    public void deleteDeposit(Long depositId) {
        depositRepository.deleteById(depositId);
    }
}
