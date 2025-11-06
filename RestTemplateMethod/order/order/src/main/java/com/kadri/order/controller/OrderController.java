package com.kadri.order.controller;

import com.kadri.order.entity.Order;
import com.kadri.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order){
        Order savedOrder = service.placeOrder(order);
        return ResponseEntity.ok(savedOrder);
    }

}
