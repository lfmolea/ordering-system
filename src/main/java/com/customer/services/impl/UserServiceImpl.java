package com.customer.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.customer.entity.User;
import com.customer.repositories.RoleRepository;
import com.customer.repositories.UserRepository;
import com.customer.security.UserRole;
import com.customer.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) {
		User localUser = userRepository.findByUsername(user.getUsername());

		if (localUser != null) {
			LOG.info("user {} already exists. Nothing will be done.", user.getUsername());
		} else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}

			user.getUserRoles().addAll(userRoles);

			localUser = userRepository.save(user);
		}

		return localUser;
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}


	@Override
		public User delete(long id) {
			User user = findById(id);
			if(user != null){
				userRepository.delete(user);
			}
			return user;
		}

	@Override
	public User findById(long id) {
		User user = userRepository.getOne(id);
		return user;
	}


	@Override
		public List findAll() {
			return userRepository.findAll();
		}



		@Override
		public User update(User user) {
			return null;
		}
	}