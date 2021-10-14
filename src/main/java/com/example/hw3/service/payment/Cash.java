package com.example.hw3.service.payment;

import com.example.hw3.model.checkout.Bill;
import com.example.hw3.model.enums.PayType;
import org.springframework.stereotype.Component;

@Component
public class Cash implements Payment {

    @Override
    public PayType getType() {
        return PayType.CASH;
    }

    @Override
    public void pay(Bill bill) {
        System.out.println("Payment completed with cash, Total Price: " + bill.getTotalPrice());
    }
}
