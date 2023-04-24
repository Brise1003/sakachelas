package com.sakachelas.persistance.crud;

import com.sakachelas.persistance.entity.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PedidoCrudRepository extends CrudRepository<Pedido, Integer> {

    @Query(value = "SELECT * FROM pedidos WHERE idUsuario = ? ORDER BY fecha", nativeQuery = true)
    List<Pedido> getByUserId(Integer userId);
}
