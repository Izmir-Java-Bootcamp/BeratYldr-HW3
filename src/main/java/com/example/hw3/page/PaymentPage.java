package com.example.hw3.page;

import com.example.hw3.model.categories.Categories;
import com.example.hw3.model.checkout.Bill;
import com.example.hw3.model.enums.PayType;
import com.example.hw3.service.payment.Payment;
import com.example.hw3.service.payment.PaymentFactory;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Scanner;


@Component
@Data
public class PaymentPage{
    private final Scanner scanner;
    private final PaymentFactory paymentFactory;
    public void run(Bill bill) {
        System.out.print("SELECT PAYMENT METHOD "+ Arrays.toString(PayType.values())+" : ");
        PayType payType=PayType.valueOf(scanner.nextLine());
        Payment payment =paymentFactory.getType(payType);
        payment.pay(bill);
    }
}
