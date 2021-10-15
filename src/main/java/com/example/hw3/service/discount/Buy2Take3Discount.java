package com.example.hw3.service.discount;


import com.example.hw3.model.cart.Cart;
import com.example.hw3.model.cart.CartItem;
import com.example.hw3.properties.DiscountProperties;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Data
public class Buy2Take3Discount implements Discount {

    private final DiscountProperties discountProperties;
    List<Double> doubleList=new ArrayList<>();
    @Override
    public double applyDiscount(CartItem cartItem) {


            int quantity=cartItem.getQuantity();
            int discountQuantity = quantity/ 3;
            int paidQuantity = quantity - discountQuantity;
            return (paidQuantity * (cartItem.getPrice()/quantity)) ;


    }

    @Override
    public boolean isAcceptable(Cart cart) {
        return cart.getCartItems().get(0).getQuantity()>5;
    }
}
