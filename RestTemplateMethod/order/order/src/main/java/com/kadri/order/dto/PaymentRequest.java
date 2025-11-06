package com.kadri.order.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PaymentRequest {
    //Long orderId;
    Double amount;
    PaymentMethod paymentMethod;
}
