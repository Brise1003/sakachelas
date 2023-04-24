package com.sakachelas.persistance;

import com.sakachelas.persistance.crud.PedidoCrudRepository;
import com.sakachelas.persistance.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PedidoRepository {
    @Autowired
    private PedidoCrudRepository pedidoCrudRepository;

    public List<Pedido> getByUserId(int userId){
        return (List<Pedido>) pedidoCrudRepository.getByUserId(userId);
    }
}
