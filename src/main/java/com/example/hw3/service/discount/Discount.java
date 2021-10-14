package com.example.hw3.service.discount;

import com.example.hw3.model.cart.Cart;

public interface Discount {
    double applyDiscount(Cart cart);
    boolean isAcceptable(Cart cart);
}
