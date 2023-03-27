package com.example.autoservice.controller;

import com.example.autoservice.dto.mapper.ProductMapper;
import com.example.autoservice.dto.request.ProductRequestDto;
import com.example.autoservice.dto.response.CarResponseDto;
import com.example.autoservice.dto.response.ProductResponseDto;
import com.example.autoservice.model.Product;
import com.example.autoservice.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping
    public ProductResponseDto create(@RequestBody ProductRequestDto productRequestDto) {
        Product product = productService.save(productMapper.mapToModel(productRequestDto));
        return productMapper.mapToDto(product);
    }

    @PutMapping("/{id}")
    public ProductResponseDto update(@PathVariable Long id,
                                     @RequestBody ProductRequestDto productRequestDto) {
        Product product = productMapper.mapToModel(productRequestDto);
        product.setId(id);
        return productMapper.mapToDto(productService.save(product));
    }

    @GetMapping
    public List<ProductResponseDto> getProducts() {
        return productService.findAll().stream()
                .map(productMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
