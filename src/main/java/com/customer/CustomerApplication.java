package com.customer;

import com.customer.entity.Customer;
import com.customer.security.Role;
import com.customer.security.UserRole;
import com.customer.services.CustomerService;
import com.customer.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class CustomerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
	@Autowired
	private CustomerService customerService;
	@Override
	public void run(String... args) throws Exception {
		Customer user1 = new Customer();
		user1.setUsername("admin");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
		user1.setEmailAddress("lmolea@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1= new Role();
		//role1.setRoleId(0);
		role1.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user1, role1));

		customerService.createCustomer(user1, userRoles);
	}

}
