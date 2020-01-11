package com.customer.rest.controller;

import com.customer.entity.Customer;
import com.customer.security.Role;
import com.customer.security.UserRole;
import com.customer.services.CustomerService;
import com.customer.services.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/new")
    public void createCustomer(@RequestBody @Valid Customer customer)throws Exception{

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Set<UserRole> roles = new HashSet<>();

       /* for (GrantedAuthority grantedAuthority: authentication.getAuthorities()){

            UserRole userRole = new UserRole();
            Role role = new Role();
            role.setName(grantedAuthority.getAuthority());

            userRole.setCustomer(customer);

            roles.add(userRole);
        }*/
        Role role = new Role();
        role.setName("ADMIN");

        UserRole userRole = new UserRole();
        userRole.setRole(role);

        roles.add(userRole);

        customerService.createCustomer(customer, roles);
    }
}
