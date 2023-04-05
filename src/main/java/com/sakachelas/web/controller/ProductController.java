package com.sakachelas.web.controller;

import com.sakachelas.domain.Product;
import com.sakachelas.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    public List<Product> getAll(){
        return productService.getAll();
    }

    public Optional<List<Product>> getByBrand(String brand){
        return productService.getByBrand(brand);
    }

    public Optional<List<Product>> getByStyle(String style){
        return productService.getByStyle(style);
    }

    public Optional<Product> getProduct(int productId){
        return productService.getProduct(productId);
    }

    public Product save(Product product){
        return productService.save(product);
    }

    public boolean delete(int productId){
        return getProduct(productId).map(product -> {
            productService.delete(productId);
            return true;
        }).orElse(false);
    }
}
