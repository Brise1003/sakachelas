package com.sakachelas.persistance;

import com.sakachelas.persistance.crud.PedidoCrudRepository;
import com.sakachelas.persistance.entity.Pedido;

import java.util.List;

public class PedidoRepository {
    private PedidoCrudRepository pedidoCrudRepository;

    public List<Pedido> getAll(){
        return (List<Pedido>) pedidoCrudRepository.findAll();
    }
}
