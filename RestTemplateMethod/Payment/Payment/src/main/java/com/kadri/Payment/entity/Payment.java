package com.kadri.Payment.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private String status;
    private String transactionId;

}
