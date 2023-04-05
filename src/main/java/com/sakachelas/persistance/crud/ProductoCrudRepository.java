package com.sakachelas.persistance.crud;

import com.sakachelas.persistance.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    @Query(value = "SELECT * FROM productos WHERE marca = ? ORDER BY nombreProducto", nativeQuery = true)
    List<Producto> getByMarca(String marca);

    List<Producto> findByEstiloOrderByNombreProducto(String estilo);


}
