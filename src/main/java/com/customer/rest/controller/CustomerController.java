package com.customer.rest.controller;


import com.customer.entity.User;
import com.customer.repositories.UserRepository;
import com.customer.security.Role;
import com.customer.security.UserRole;
import com.customer.services.UserService;
import com.customer.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    @Autowired
    UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/new")
    public void createCustomer(@RequestBody @Valid User customer)throws Exception{

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

        userService.createUser(customer, roles);




    }
    @GetMapping("/users")
    public List<User> getAllCustomers(Model model) {
        List<User> customerList = (List<User>) userRepository.findAll();
        model.addAttribute("customerList", customerList);
        return customerList;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getCustomerById(@PathVariable(value = "id") Long customerId)
            throws Exception {
        User customer = userRepository.findById(customerId)
                .orElseThrow(() -> new Exception("Employee not found for this id :: " + customerId));
        return ResponseEntity.ok().body(customer);
    }
}
