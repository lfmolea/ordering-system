package com.customer.repositories;

import com.customer.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByUsername(String username);
}
