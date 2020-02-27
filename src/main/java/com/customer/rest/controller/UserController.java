package com.customer.rest.controller;


import com.customer.entity.User;
import com.customer.security.UserRole;
import com.customer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/users"})
public class UserController {

    @Autowired
    private UserService userService;
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Set<UserRole> roles = new HashSet<>();
    @PostMapping
    public User create(@RequestBody @Valid User user)throws Exception{
        return userService.createUser(user, roles);
    }

    @GetMapping(path = {"/{id}"})
    public User findOne(@PathVariable("id") long id){
        return userService.findById(id);
    }

    @PutMapping
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping(path ={"/{id}"})
    public User delete(@PathVariable("id") long id) {
        return userService.delete(id);
    }

    @GetMapping
    public List findAll(){
        return userService.findAll();
    }
}
