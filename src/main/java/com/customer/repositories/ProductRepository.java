package com.customer.repositories;


import com.customer.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

   /* Product findOne(Long id);

    void delete(Long id);
*/
}
