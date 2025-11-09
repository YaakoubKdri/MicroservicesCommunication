package com.kadri.paymentservice.controller;

import com.kadri.paymentservice.dto.PaymentRequest;
import com.kadri.paymentservice.dto.PaymentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    @PostMapping("/charge")
    public ResponseEntity<PaymentResponse> charge(@RequestBody PaymentRequest request){
        PaymentResponse response = PaymentResponse.builder()
                .orderId(request.getOrderId())
                .status("PAID")
                .transactionId("tx-" + System.currentTimeMillis())
                .build();
        return ResponseEntity.ok(response);
    }
}
