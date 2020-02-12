package com.customer.services;

import com.customer.entity.User;
import com.customer.security.UserRole;


import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {

    User createUser(User user, Set<UserRole> userRoles) throws Exception;

    User save(User user);

    User update(User user);

    User delete(long id);

    User findById(long id);

    List findAll();
}