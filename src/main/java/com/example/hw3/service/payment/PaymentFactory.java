package com.example.hw3.service.payment;

import com.example.hw3.model.enums.PayType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PaymentFactory {
    private final Map<PayType, Payment> paymentMap;

    public PaymentFactory(List<Payment> payments) {
        this.paymentMap = payments.stream()
                .collect(Collectors.toMap(Payment::getType, payment -> payment));
    }

    public Payment getType(PayType type) {
        return paymentMap.get(type);
    }
}

