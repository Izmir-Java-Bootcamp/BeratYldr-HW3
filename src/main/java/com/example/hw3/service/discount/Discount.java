package com.example.hw3.service.discount;

import com.example.hw3.model.cart.Cart;
import com.example.hw3.model.cart.CartItem;

public interface Discount {
    double applyDiscount(CartItem cart);
    boolean isAcceptable(Cart cart);
}
