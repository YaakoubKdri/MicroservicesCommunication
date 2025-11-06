package com.kadri.order.service;

import com.kadri.order.dto.PaymentMethod;
import com.kadri.order.dto.PaymentRequest;
import com.kadri.order.dto.PaymentResponse;
import com.kadri.order.entity.Order;
import com.kadri.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final RestTemplate restTemplate;

    @Value("${payment.service.url}")
    private String paymentServiceUrl;

    public Order placeOrder(Order order) {
        //save initial order
        order.setStatus("PENDING");
        repository.save(order);
        //prepare payment request
        PaymentRequest paymentRequest = PaymentRequest.builder()
                //.orderId(order.getId())
                .amount(order.getAmount())
                .paymentMethod(PaymentMethod.CREDIT_CARD)
                .build();
        //call Payment service

        String url = paymentServiceUrl + "/payments";
        ResponseEntity<PaymentResponse> paymentResponse =
                restTemplate.postForEntity(url, paymentRequest, PaymentResponse.class);
        //update order status based on payment
        if(paymentResponse.getBody() != null && "SUCCESS".equals(paymentResponse.getBody().getStatus())){
            order.setStatus("CONFIRMED");
        }else{
            order.setStatus("CANCELED");
        }

        return repository.save(order);

    }
}
