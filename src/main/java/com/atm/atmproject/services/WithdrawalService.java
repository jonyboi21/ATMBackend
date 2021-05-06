package com.atm.atmproject.services;

import com.atm.atmproject.models.Withdrawal;
import com.atm.atmproject.repositories.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WithdrawalService {

    @Autowired
    private WithdrawalRepository withdrawalRepository;

//    public void getAllWithdrawals(Long accountId) {
//        Iterable<Withdrawal> allWithdrawals = withdrawalRepository.findAll(accountId);
//    }

    public Optional<Withdrawal> getWithdrawal(Long withdrawalId) {
        return withdrawalRepository.findById(withdrawalId);
    }

    public void createWithdrawal(Withdrawal withdrawal) {
        withdrawalRepository.save(withdrawal);
    }

    public void updateWithdrawal(Withdrawal withdrawal, Long withdrawalId) {
        withdrawalRepository.save(withdrawal);
    }

    public void deleteWithdrawal(Long withdrawalId) {
        withdrawalRepository.deleteById(withdrawalId);
    }
}
