package com.customer.services;

import com.customer.entity.Product;

import java.util.List;

public interface ProductService {
    public Product save(Product product);

    public List<Product> findAll();

    public Product findOne(Long id);

    public void removeOne(Long id);

}
