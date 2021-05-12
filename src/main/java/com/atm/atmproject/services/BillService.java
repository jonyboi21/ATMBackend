package com.atm.atmproject.services;

import com.atm.atmproject.controllers.BillController;
import com.atm.atmproject.models.Bill;
import com.atm.atmproject.repositories.BillRepo;
import com.atm.atmproject.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillService {

    private static final Logger logger = LoggerFactory.getLogger(BillService.class);

    @Autowired
    private BillRepo billRepo;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BillController billController;

    public Iterable<Bill> getAllByAccountId(Long accountId) {
        logger.info("SUCCESSFULLY RETRIEVED ALL BILLS BY ACCOUNT ID: " + accountId);
        return billRepo.getAllBillsByAccountId(accountId);
    }

    public Iterable<Bill> getAllByCustomerId(Long customerId) {
        logger.info("SUCCESSFULLY RETRIEVED ALL BILLS BY Customer ID: " + customerId);
        return billRepo.getAllBillsByCustomerId(customerId);
    }

    public Optional<Bill> getById(Long billId) {
        logger.info("SUCCESSFULLY RETRIEVED Bill WITH THE ID: " + billId);
        return billRepo.findById(billId);
    }

    public void createBill(Bill bill) {
        logger.info("BILL SUCCESSFULLY CREATED");
        billRepo.save(bill);
    }

    public void updateBill(Bill bill, Long billId) {
        logger.info("BILL WITH ID: " + billId + " SUCCESSFULLY UPDATED");
        billRepo.save(bill);
    }

    public void deleteBill(Long billId) {
        logger.info("BILL WITH ID: " + billId + " REMOVED FROM SYSTEM");
        billRepo.deleteById(billId);
    }
}
