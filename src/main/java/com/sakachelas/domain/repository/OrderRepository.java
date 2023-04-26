package com.sakachelas.domain.repository;

import com.sakachelas.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    List<Order> getAll();
    Optional<List<Order>> getByClient(int userId);
    Order save(Order order);
}
