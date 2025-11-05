package com.kadri.Payment.service;

import com.kadri.Payment.entity.Payment;
import com.kadri.Payment.repository.PaymentRepository;
import com.kadri.Payment.response.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository repository;
    private final ModelMapper mapper;

    public PaymentResponse processPayment(Payment payment) {
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setStatus("SUCCESS");
        return mapper.map(repository.save(payment), PaymentResponse.class);
    }

    public PaymentResponse getPaymentByOrderId(Long orderId) {
        return mapper.map(repository.findByOrderId(orderId), PaymentResponse.class);
    }
}
