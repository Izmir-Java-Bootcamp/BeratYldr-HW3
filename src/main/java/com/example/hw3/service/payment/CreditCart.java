package com.example.hw3.service.payment;

import com.example.hw3.model.checkout.Bill;
import com.example.hw3.model.enums.PayType;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "discount")
@Data
public class CreditCart implements Payment {
    private  int creditCartCommission;
    @Override
    public PayType getType() {
        return PayType.CREDIT;
    }

    @Override
    public void pay(Bill bill) {
        double commission = bill.getTotalPrice() * (creditCartCommission*0.01);
        double price = bill.getTotalPrice() + commission;

        System.out.printf("Credit Cart payment completed." +
                "Commission charge: %s " +
                "Commision Rate: %s " +
                "Payment After commission: %s", commission,creditCartCommission, price);
    }
}
