package com.example.producto2.service.productService;

import com.example.producto2.model.Product;
import com.example.producto2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    public Object findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        Product currentProduct = productRepository.findById(product.getId()).get();
        currentProduct.setName(product.getName());
        currentProduct.setDescription(product.getDescription());
        currentProduct.setKcal(product.getKcal());
        return productRepository.save(currentProduct);
    }
    @Override
    public void delete(Long id) {
        Optional<Product> menu = productRepository.findById(id);
        System.out.println(menu);
        productRepository.deleteById(id);
    }
}
