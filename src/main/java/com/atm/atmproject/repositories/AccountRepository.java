package com.atm.atmproject.repositories;

import com.atm.atmproject.models.Account;
import com.atm.atmproject.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {


    Optional<Account> findByCustomerId(Long customerId);

    Iterable<Customer> findCustomerByAccountId(Long accountId);

    Iterable<Account> findAllAccountsByCustomer(Long customerId);


}
