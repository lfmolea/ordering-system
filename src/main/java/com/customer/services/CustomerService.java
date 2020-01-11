package com.customer.services;

import com.customer.entity.Customer;
import com.customer.security.UserRole;

import java.util.Set;

public interface CustomerService {
    Customer createCustomer(Customer customer, Set<UserRole> userRoles) throws Exception;

    Customer save(Customer customer);
}
