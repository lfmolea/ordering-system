package com.customer.services.impl;

import java.util.Set;

import com.customer.entity.Customer;
import com.customer.repositories.CustomerRepository;
import com.customer.repositories.RoleRepository;
import com.customer.security.UserRole;
import com.customer.services.CustomerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger LOG = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private CustomerRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Customer createCustomer(Customer customer, Set<UserRole> userRoles) {
		Customer localUser = userRepository.findByUsername(customer.getUsername());

		if (localUser != null) {
			LOG.info("user {} already exists. Nothing will be done.", customer.getUsername());
		} else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}

			customer.getUserRoles().addAll(userRoles);

			localUser = userRepository.save(customer);
		}

		return localUser;
	}

	@Override
	public Customer save(Customer customer) {
		return userRepository.save(customer);
	}

}
