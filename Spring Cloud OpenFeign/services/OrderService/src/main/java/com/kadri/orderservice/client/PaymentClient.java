package com.kadri.orderservice.client;

import com.kadri.orderservice.dto.PaymentRequest;
import com.kadri.orderservice.dto.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "payment-service")
public interface PaymentClient {
    @PostMapping("/api/v1/payments/charge")
    PaymentResponse charge(PaymentRequest request);
}
