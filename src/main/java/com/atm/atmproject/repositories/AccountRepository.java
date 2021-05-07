package com.atm.atmproject.repositories;

import com.atm.atmproject.models.Account;
import com.atm.atmproject.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {


Iterable<Account> findAllByCustomerId(Long customerId);



}
