package com.kadri.Payment.controller;

import com.kadri.Payment.entity.Payment;
import com.kadri.Payment.response.PaymentResponse;
import com.kadri.Payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService service;
    @PostMapping
    public ResponseEntity<PaymentResponse> makePayment(@RequestBody Payment payment){
        PaymentResponse response = service.processPayment(payment);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/order/{orderId}")
    public PaymentResponse getPaymentByOrderId(@PathVariable("orderId") Long orderId){
        return service.getPaymentByOrderId(orderId);
    }
}
