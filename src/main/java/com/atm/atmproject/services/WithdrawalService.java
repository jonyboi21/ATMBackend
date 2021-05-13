package com.atm.atmproject.services;

import com.atm.atmproject.exception.ResourceNotFoundException;
import com.atm.atmproject.models.Withdrawal;
import com.atm.atmproject.repositories.AccountRepository;
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

    @Autowired
    private AccountRepository accountRepository;

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

    public void createWithdrawal(Withdrawal withdrawal) throws ResourceNotFoundException {
        accountRepository.findById(withdrawal.getAccountId()).get().getBalance();
        if (withdrawal.getAmount() > accountRepository.findById(withdrawal.getAccountId()).get().getBalance()) {
            logger.info("CANNOT WITHDRAWAL AMOUNT GREATER THAN ACCOUNT BALANCE");
            throw new ResourceNotFoundException("Cannot withdrawal amount greater than account balance.");
        } else {
            accountRepository
                    .findById(withdrawal.getAccountId()).get()
                    .setBalance(accountRepository.findById(withdrawal.getAccountId()).get().getBalance() - withdrawal.getAmount());
            logger.info("WITHDRAWAL SUCCESSFULLY CREATED");
            withdrawalRepository.save(withdrawal);
        }
    }


    public void updateWithdrawal(Withdrawal withdrawal, Long withdrawalId) {
        accountRepository.findById(withdrawalRepository.findById(withdrawalId).get().getAccountId()).get()
                .setBalance(accountRepository.findById(withdrawalRepository.findById(withdrawalId).get().getAccountId()).get().getBalance() + withdrawalRepository.findById(withdrawalId).get().getAmount());
        accountRepository
                .findById(withdrawal.getAccountId())
                .get()
                .setBalance(withdrawalRepository.findById(withdrawalId).get().getAmount() + withdrawalRepository.findById(withdrawalId).get().getAmount() - withdrawal.getAmount());
        logger.info("WITHDRAWAL WITH ID: " + withdrawalId + " SUCCESSFULLY UPDATED");
        withdrawalRepository.save(withdrawal);
    }

    public void deleteWithdrawal(Long withdrawalId) {
        logger.info("WITHDRAWAL WITH ID: " + withdrawalId + " REMOVED FROM SYSTEM");
        withdrawalRepository.deleteById(withdrawalId);
    }
}
