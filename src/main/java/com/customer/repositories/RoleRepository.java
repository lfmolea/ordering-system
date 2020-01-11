package com.customer.repositories;

import com.customer.security.Role;
import org.springframework.data.repository.CrudRepository;




public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByname(String name);
}
