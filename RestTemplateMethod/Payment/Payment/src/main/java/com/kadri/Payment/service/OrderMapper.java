package com.kadri.Payment.service;

import com.kadri.Payment.entity.Payment;
import com.kadri.Payment.response.PaymentResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {
    public PaymentResponse fromOrder(Payment payment) {
        return new PaymentResponse(
                payment.getOrderId(),
                payment.getStatus(),
                payment.getAmount()
        );
    }
}
