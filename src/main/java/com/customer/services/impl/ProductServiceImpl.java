package com.customer.services.impl;

import java.util.List;

import com.customer.entity.Product;
import com.customer.repositories.ProductRepository;
import com.customer.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public ProductServiceImpl() {
	}

	public Product save(Product product) {
		return productRepository.save(product);
	}

	public List<Product> findAll() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product findOne(Long id) {

		Product product = productRepository.findById(id).get();
		return product;
	}

	@Override
	public void removeOne(Long id) {
        productRepository.deleteById(id);
	}
}
