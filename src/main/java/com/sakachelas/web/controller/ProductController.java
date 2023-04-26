package com.sakachelas.web.controller;

import com.sakachelas.domain.Product;
import com.sakachelas.domain.service.ProductService;
import org.apache.catalina.filters.ExpiresFilter;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Product>> getByBrand(@PathVariable("brand") String brand){
        List<Product> products = productService.getByBrand(brand).orElse(null);

        return products != null && !products.isEmpty() ?
                new ResponseEntity<>(products, HttpStatus.OK)
                : new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/style/{style}")
    public ResponseEntity<List<Product>> getByStyle(@PathVariable("style") String style){
        List<Product> products = productService.getByStyle(style).orElse(null);

        return products != null && !products.isEmpty() ?
                new ResponseEntity<>(products, HttpStatus.OK)
                : new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId){
        return productService.delete(productId) ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
