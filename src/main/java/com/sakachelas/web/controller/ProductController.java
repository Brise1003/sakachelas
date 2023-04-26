package com.sakachelas.web.controller;

import com.sakachelas.domain.Product;
import com.sakachelas.domain.service.ProductService;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/brand/{brand}")
    public Optional<List<Product>> getByBrand(@PathVariable("brand") String brand){
        return productService.getByBrand(brand);
    }

    @GetMapping("/style/{style}")
    public Optional<List<Product>> getByStyle(@PathVariable("style") String style){
        return productService.getByStyle(style);
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int productId){
        return productService.delete(productId);
    }
}
