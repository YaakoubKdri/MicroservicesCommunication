package com.kadri.orderservice.service;

import com.kadri.orderservice.client.PaymentClient;
import com.kadri.orderservice.dto.PaymentRequest;
import com.kadri.orderservice.dto.PaymentResponse;
import com.kadri.orderservice.entity.Order;
import com.kadri.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final PaymentClient paymentClient;

    @Transactional
    public Order createAndPay(Order order) {
        //save initial order
        order.setPaymentStatus("PENDING");
        Order orderSaved = repository.save(order);

        //Build Payment request
        PaymentRequest request = PaymentRequest.builder()
                .orderId(orderSaved.getId())
                .amount(orderSaved.getPrice())
                .build();

        //Call payment-service via Feign
        PaymentResponse response = paymentClient.charge(request);

        //Update Order based on payment response
        orderSaved.setPaymentStatus(response.status);
        orderSaved.setTransactionId(response.transactionId);

        return repository.save(orderSaved);
    }

    public Optional<Order> findById(Long id) {
        return repository.findById(id);
    }
}
