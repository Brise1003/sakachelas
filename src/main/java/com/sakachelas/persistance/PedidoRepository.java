package com.sakachelas.persistance;

import com.sakachelas.domain.Order;
import com.sakachelas.domain.repository.OrderRepository;
import com.sakachelas.persistance.crud.PedidoCrudRepository;
import com.sakachelas.persistance.entity.Pedido;
import com.sakachelas.persistance.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class PedidoRepository implements OrderRepository {
    @Autowired
    private PedidoCrudRepository pedidoCrudRepository;

    @Autowired
    private OrderMapper mapper;

    @Override
    public List<Order> getAll() {
        return mapper.toOrders((List<Pedido>) pedidoCrudRepository.findAll());
    }

    @Override
    public Optional<List<Order>> getByClient(int userId) {
        return pedidoCrudRepository.getByUserId(userId).map(Pedidos -> mapper.toOrders(Pedidos));
    }

    @Override
    public Optional<List<Order>> getByEmail(String email) {
        return pedidoCrudRepository.getByEmail(email).map(Pedidos -> mapper.toOrders(Pedidos));
    }

    @Override
    public Order save(Order order) {
        Pedido pedido = mapper.toPedido(order);
        pedido.getProductos().forEach(producto -> producto.setPedido(pedido));

        return mapper.toOrder(pedidoCrudRepository.save(pedido));
    }

    @Override
    public Integer getLastOrderId() {
        Order lastOrder = this.pedidoCrudRepository.getLastOrderId().map(Pedido->mapper.toOrder(Pedido)).orElse(null);
        assert lastOrder != null;
        Integer lastOrderId = lastOrder.getOrderId();
        return lastOrderId;
    }


}
