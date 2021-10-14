package com.example.hw3.service.discount;


import com.example.hw3.model.cart.Cart;
import com.example.hw3.properties.DiscountProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Data
public class Buy2Take3Discount implements Discount {

    private final DiscountProperties discountProperties;
    @Override
    public double applyDiscount(Cart cart) {
        int quantity=cart.getCartItems().get(0).getQuantity();
        int discountQuantity = quantity/ 3;
        int paidQuantity = quantity - discountQuantity;
        return paidQuantity * (cart.getTotalPrice()/quantity);
    }

    @Override
    public boolean isAcceptable(Cart cart) {
        return cart.getCartItems().get(0).getQuantity()>5;
    }
}
