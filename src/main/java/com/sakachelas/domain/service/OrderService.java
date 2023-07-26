package com.sakachelas.domain.service;

import com.sakachelas.domain.Order;
import com.sakachelas.domain.repository.OrderRepository;
import com.sakachelas.persistance.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.swing.plaf.OptionPaneUI;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    public List<Order> getAll(){
        return orderRepository.getAll();
    }

    public Optional<List<Order>> getByClient(int userId){
        return orderRepository.getByClient(userId);
    }

    public Optional<List<Order>> getByEmail(String email){
        return orderRepository.getByEmail(email);
    }

    public Order save(Order order){
        return orderRepository.save(order);
    }

    public Integer getLastOrderId(){
        return this.orderRepository.getLastOrderId();
    }

}
