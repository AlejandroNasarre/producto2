package com.example.producto2.service.productService;

import com.example.producto2.model.Product;

import java.util.Optional;

public interface IProductService {
    Object findAll();
    Optional<Product> findById(Long id);
    Product create(Product product);
    Product update(Product product);
    void delete(Long id);
}
