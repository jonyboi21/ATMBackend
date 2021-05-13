package com.atm.atmproject.services;

import com.atm.atmproject.exception.ResourceNotFoundException;
import com.atm.atmproject.models.Withdrawal;
import com.atm.atmproject.repositories.WithdrawalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WithdrawalService {

    private static final Logger logger = LoggerFactory.getLogger(WithdrawalService.class);

    @Autowired
    private WithdrawalRepository withdrawalRepository;

    public Iterable<Withdrawal> getAllByAccountId(Long accountId) {
        if (!(withdrawalRepository.findAll().iterator().hasNext())) {
            logger.info("WITHDRAWALS ARE EMPTY, FAILED TO RETRIEVE WITHDRAWALS");
            throw new ResourceNotFoundException("There are no withdrawals to fetch");
        } else {
            logger.info("SUCCESSFULLY RETRIEVED ALL WITHDRAWALS BY ACCOUNT ID");
            return withdrawalRepository.findAllByAccountId(accountId);
        }
    }

    public Optional<Withdrawal> getWithdrawal(Long withdrawalId) {
        logger.info("SUCCESSFULLY RETRIEVED WITHDRAWAL WITH ID: " + withdrawalId);
        return withdrawalRepository.findById(withdrawalId);
    }

    public void createWithdrawal(Withdrawal withdrawal) {
        logger.info("WITHDRAWAL SUCCESSFULLY CREATED");
        withdrawalRepository.save(withdrawal);
    }

    public void updateWithdrawal(Withdrawal withdrawal, Long withdrawalId) {
        logger.info("WITHDRAWAL WITH ID: " + withdrawalId + " SUCCESSFULLY UPDATED");
        withdrawalRepository.save(withdrawal);
    }

    public void deleteWithdrawal(Long withdrawalId) {
        logger.info("WITHDRAWAL WITH ID: " + withdrawalId + " REMOVED FROM SYSTEM");
        withdrawalRepository.deleteById(withdrawalId);
    }
}
