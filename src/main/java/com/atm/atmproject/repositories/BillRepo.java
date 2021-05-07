package com.atm.atmproject.repositories;

import com.atm.atmproject.models.Account;
import com.atm.atmproject.models.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BillRepo extends CrudRepository<Bill,Long> {


  Iterable<Bill> getAllBillsByAccountId(Long accountId);

  Iterable<Bill> getAllBillsByCustomerId(Long customerId);
}
