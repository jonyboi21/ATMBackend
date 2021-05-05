package com.atm.atmproject.repositories;

import com.atm.atmproject.models.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
