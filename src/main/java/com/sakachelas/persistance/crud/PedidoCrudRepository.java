package com.sakachelas.persistance.crud;

import com.sakachelas.persistance.entity.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoCrudRepository extends CrudRepository<Pedido, Integer> {
}
