package com.atm.atmproject.repositories;

import com.atm.atmproject.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
//    Optional<Account> findByAccountId(Long accountId);
}
