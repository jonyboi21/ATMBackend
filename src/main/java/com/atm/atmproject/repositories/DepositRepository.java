package com.atm.atmproject.repositories;

import com.atm.atmproject.models.Deposit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository extends CrudRepository <Deposit, Long> {

    Iterable<Deposit> findAllByAccountId (Long accountId);
}
