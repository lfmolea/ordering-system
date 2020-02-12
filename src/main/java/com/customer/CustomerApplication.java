package com.customer;


import com.customer.entity.Product;
import com.customer.entity.User;
import com.customer.repositories.UserRepository;
import com.customer.security.Role;
import com.customer.security.UserRole;
import com.customer.services.ProductService;
import com.customer.services.UserService;
import com.customer.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class CustomerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private ProductService productService;
	@Override
	public void run(String... args) throws Exception {


		User user1 = new User();
		user1.setUsername("admin");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
		user1.setEmailAddress("admin@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1= new Role();
		role1.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user1, role1));

		userService.createUser(user1, userRoles);

		Product product1 = new Product();
		product1.setActive(true);
		product1.setBarcode(288888888);
		product1.setColor("blue");
		product1.setProductName("Scalf");
		product1.setType("Scalf");
		product1.setListPrice(23.4);
		product1.setOurPrice(15.0);

		productService.save(product1);
	}
	/*@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/products").allowedOrigins("http://localhost:8080");
			}
		};
	}*/

}
