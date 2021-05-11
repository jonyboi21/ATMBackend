package com.atm.atmproject.services;

import com.atm.atmproject.models.Deposit;
import com.atm.atmproject.repositories.DepositRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepositService {

    private static final Logger logger = LoggerFactory.getLogger(DepositService.class);

    @Autowired
    private DepositRepository depositRepository;

    public Iterable<Deposit> getAllByAccountId(Long accountId) {
        logger.info("SUCCESSFULLY RETRIEVED ALL DEPOSITS BY ACCOUNT ID");
        return depositRepository.findAllByAccountId(accountId);
    }

    public Optional<Deposit> getById(Long depositId) {
        logger.info("SUCCESSFULLY RETRIEVED DEPOSIT WITH ID: " + depositId);
        return depositRepository.findById(depositId);
    }

    public void createDeposit(Deposit deposit) {
        logger.info("DEPOSIT SUCCESSFULLY CREATED");
        depositRepository.save(deposit);
    }

    public void updateDeposit(Deposit deposit, Long depositId) {
        logger.info("DEPOSIT WITH ID: " + depositId + " SUCCESSFULLY UPDATED");
        depositRepository.save(deposit);
    }

    public void deleteDeposit(Long depositId) {
        logger.info("DEPOSIT WITH ID: " + depositId + " REMOVED FROM SYSTEM");
        depositRepository.deleteById(depositId);
    }
}
