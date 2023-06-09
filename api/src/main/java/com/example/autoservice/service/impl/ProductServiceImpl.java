package com.example.autoservice.service.impl;

import com.example.autoservice.model.Product;
import com.example.autoservice.repository.ProductRepository;
import com.example.autoservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find product by id " + id));
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
