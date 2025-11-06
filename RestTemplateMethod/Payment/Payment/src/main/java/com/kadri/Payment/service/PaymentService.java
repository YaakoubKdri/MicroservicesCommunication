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
    private final OrderMapper mapper;

    public PaymentResponse processPayment(Payment payment) {
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setStatus("SUCCESS");
        var response = repository.save(payment);
        return mapper.fromOrder(response);
    }

    public PaymentResponse getPaymentByOrderId(Long orderId) {
        return mapper.fromOrder(repository.findByOrderId(orderId));
    }
}
