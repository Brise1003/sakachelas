package com.sakachelas.web.controller;

import com.sakachelas.domain.Order;
import com.sakachelas.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAll(){
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<List<Order>> getByClient(@PathVariable("id") int userId){
        return orderService.getByClient(userId);
    }

    @PostMapping("/save")
    public Order save(Order order){
        return orderService.save(order);
    }
}
