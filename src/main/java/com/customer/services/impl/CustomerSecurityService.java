package com.customer.services.impl;

import com.customer.entity.Customer;
import com.customer.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerSecurityService implements UserDetailsService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = customerRepository.findByUsername(username);
		
		if(null == customer) {
			throw new UsernameNotFoundException("Username not found");
		}
		
		return customer;
	}

}
