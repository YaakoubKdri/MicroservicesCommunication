package com.kadri.orderservice.controller;

import com.kadri.orderservice.entity.Order;
import com.kadri.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        Order orderCreated = service.createAndPay(order);
        return ResponseEntity.ok(orderCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> get(@PathVariable Long id ){
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
