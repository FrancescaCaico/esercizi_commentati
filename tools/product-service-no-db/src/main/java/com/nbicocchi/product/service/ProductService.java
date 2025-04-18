package com.nbicocchi.product.service;

import com.nbicocchi.product.persistence.model.Product;
import com.nbicocchi.product.persistence.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
"""
LA CLASSE SERVICE NON FA ALTRO CHE DA PONTE TRA IL CONTROLLER E LA PERSISTENZA CHE è RAPPRESENTATA DAL REPOSITORY
CHE IN QUESTO CONTESTO è INSERITO ESEGUENDO UNA DEPENDENCY INJECTION TRAMITE COSTRUTTORE

 private final ProductRepository productRepository;
 public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

DOPO DI CHE I METODI IMPLEMENTATI NON FANNO ALTRP CHE CHIAMARE I METODI DEL REPOSITORY
"""
*/


@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findByUuid(String uuid) {
        return productRepository.findByUuid(uuid);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }
}
