package com.atm.atmproject.repositories;

import com.atm.atmproject.models.Withdrawal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawalRepository extends CrudRepository<Withdrawal, Long> {
}
