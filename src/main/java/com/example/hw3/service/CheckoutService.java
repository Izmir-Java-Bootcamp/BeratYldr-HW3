package com.example.hw3.service;

import com.example.hw3.model.cart.Cart;
import com.example.hw3.model.checkout.Bill;
import com.example.hw3.model.checkout.BillItem;
import com.example.hw3.service.discount.DiscountStrategy;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ConfigurationProperties(prefix = "discount")
@Data
public class CheckoutService {
    private int deliveryFee;
    private int deliveryFeeLimit;
    private final DiscountStrategy discountStrategy;
    public Bill checkout(Cart cart) {
        List<BillItem> billItems = cart.getCartItems()
                .stream()
                .map(cartItem -> BillItem.builder()
                        .productName(cartItem.getProduct().getName())
                        .quantity(cartItem.getQuantity())
                        .price(cartItem.getPrice())
                        .description(cartItem.getProduct().getDescription())
                        .discountedPrice(discountStrategy.applyDiscount(cart))
                        .build())
                .collect(Collectors.toList());

        double totalSum = billItems.stream()
                .map(BillItem::getDiscountedPrice)
                .mapToDouble(d -> d)
                .sum();


        if(totalSum==0){
            totalSum= cart.getTotalPrice();
        }
        if(totalSum<deliveryFeeLimit){
            totalSum=totalSum+deliveryFee;
        }

        return Bill.builder()
                .billItems(billItems)
                .totalPrice(totalSum)
                .build();
    }
}