package com.atm.atmproject.repositories;

import com.atm.atmproject.models.Bill;
import org.springframework.data.repository.CrudRepository;

public interface BillRepo extends CrudRepository<Bill,Long> {


}
