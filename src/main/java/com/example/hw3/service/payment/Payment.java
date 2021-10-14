package com.example.hw3.service.payment;


import com.example.hw3.model.checkout.Bill;
import com.example.hw3.model.enums.PayType;

public interface Payment {
    PayType getType();
    void pay(Bill bill);

}
