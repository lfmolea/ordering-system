package com.customer.rest.controller;

import com.customer.entity.Product;
import com.customer.repositories.ProductRepository;
import com.customer.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list-products")
    public List<Product> getProducts() {
        return (List<Product>) productService.findAll();
    }

    @PostMapping("/add-product")
    void addProduct(@RequestBody Product product) {
        productService.save(product);
    }
}