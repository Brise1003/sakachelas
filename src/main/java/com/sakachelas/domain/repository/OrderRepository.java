package com.sakachelas.domain.repository;

import com.sakachelas.domain.Order;
import com.sakachelas.persistance.entity.Pedido;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    List<Order> getAll();
    Optional<List<Order>> getByClient(int userId);
    Optional<List<Order>> getByEmail(String email);
    Order save(Order order);
    Integer getLastOrderId();
}
