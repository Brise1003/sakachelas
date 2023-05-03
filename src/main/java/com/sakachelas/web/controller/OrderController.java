package com.sakachelas.web.controller;

import com.sakachelas.domain.Order;
import com.sakachelas.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAll(){
        return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Order>> getByClient(@PathVariable("id") int userId){
        return orderService.getByClient(userId)
                .map(orders -> new ResponseEntity<>(orders ,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Order> save(@RequestBody Order order){
        return new ResponseEntity<>(orderService.save(order), HttpStatus.OK);
    }
}
