package com.kadri.Payment.response;

import com.kadri.Payment.entity.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {
    private Long paymentId;
    private String paymentStatus;
    private Double amountPaid;
}
