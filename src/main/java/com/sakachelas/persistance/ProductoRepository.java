package com.sakachelas.persistance;

import com.sakachelas.domain.Product;
import com.sakachelas.domain.repository.ProductRepository;
import com.sakachelas.persistance.crud.ProductoCrudRepository;
import com.sakachelas.persistance.entity.Producto;
import com.sakachelas.persistance.mapper.ProductMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos= (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByBrand(String brand) {
        List<Producto> productos = productoCrudRepository.getByMarca(brand);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getByStyle(String style) {
        List<Producto> productos = productoCrudRepository.findByEstiloOrderByNombre(style);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }
    
    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }
}
