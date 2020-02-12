package com.customer.repositories;


import com.customer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.jws.soap.SOAPBinding;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);
}
