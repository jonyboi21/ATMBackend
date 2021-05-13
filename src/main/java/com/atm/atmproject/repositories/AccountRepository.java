package com.atm.atmproject.repositories;

import com.atm.atmproject.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    Iterable<Account> findAllByCustomerId(Long customerId);

    Integer countAllByCustomerId(Long customerId);
}
