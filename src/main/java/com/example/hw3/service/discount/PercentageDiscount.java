package com.example.hw3.service.discount;

import com.example.hw3.model.cart.Cart;
import com.example.hw3.model.cart.CartItem;
import com.example.hw3.properties.DiscountProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Data
public class PercentageDiscount implements Discount {

    private final DiscountProperties discountProperties;

    @Override
    public double applyDiscount(CartItem cartItem) {
        double price=cartItem.getPrice();
        double appliedDiscount = price *(discountProperties.getDiscountPercentage()/100);
        System.out.println(price - appliedDiscount+"   "+discountProperties.getDiscountPercentage());
        return price - appliedDiscount;
    }

    @Override
    public boolean isAcceptable(Cart cart) {

        return cart.getTotalPrice()>=1000;
    }


}
