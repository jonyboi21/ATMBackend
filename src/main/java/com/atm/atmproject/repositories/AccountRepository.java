package com.atm.atmproject.repositories;

import com.atm.atmproject.models.Account;
import com.atm.atmproject.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Iterable<Account> findByCustomerId(Long customerId);
}
