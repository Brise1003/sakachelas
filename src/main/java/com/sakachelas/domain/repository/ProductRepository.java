package com.sakachelas.domain.repository;

import com.sakachelas.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByBrand(String brand);
    Optional<List<Product>> getByStyle(String style);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
