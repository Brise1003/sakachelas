package com.sakachelas.persistance.crud;

import com.sakachelas.persistance.entity.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PedidoCrudRepository extends CrudRepository<Pedido, Integer> {

    @Query(value = "SELECT * FROM pedidos WHERE id_usuario = ? ORDER BY fecha", nativeQuery = true)
    Optional<List<Pedido>> getByUserId(Integer userId);
}
