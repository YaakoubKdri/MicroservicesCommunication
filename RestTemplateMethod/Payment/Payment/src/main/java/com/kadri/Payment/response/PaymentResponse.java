package com.kadri.Payment.response;

import com.kadri.Payment.entity.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {
    private Long orderId;
    private Double amount;
    private PaymentMethod paymentMethod;
    private String status;
    private String transactionId;
}
