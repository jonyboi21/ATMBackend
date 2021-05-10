package com.atm.atmproject.repositories;

import com.atm.atmproject.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

<<<<<<< HEAD

Iterable<Account> findAllByCustomerId(Long customerId);

Integer countAllByCustomerId(Long customerId);
=======
    Iterable<Account> findAllByCustomerId(Long customerId);

>>>>>>> f4a6883f34d229f17c13981aa4215a8b84a25732

}
