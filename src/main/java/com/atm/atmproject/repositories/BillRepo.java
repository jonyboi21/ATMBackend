package com.atm.atmproject.repositories;

import com.atm.atmproject.models.Account;
import com.atm.atmproject.models.Bill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BillRepo extends CrudRepository<Bill,Long> {


    Iterable<Bill> getAllBills(Long customerId);
}
