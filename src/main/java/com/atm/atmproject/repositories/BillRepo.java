package com.atm.atmproject.repositories;

import com.atm.atmproject.models.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepo extends CrudRepository<Bill, Long> {


    Iterable<Bill> getAllBillsByAccountId(Long accountId);

    Iterable<Bill> getAllBillsByCustomerId(Long customerId);
}
