package com.example.autoservice.service;

import com.example.autoservice.model.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);

    Product update(Product product);

    Product findById(Long id);

    List<Product> findAll();
}
