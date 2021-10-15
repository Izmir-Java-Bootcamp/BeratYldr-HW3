package com.example.hw3.service.discount;

import com.example.hw3.model.cart.Cart;
import com.example.hw3.model.cart.CartItem;
import com.example.hw3.properties.DiscountProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiscountStrategy {

        private final List<Discount> discountList;
        private double price=0;
    public double applyDiscount(Cart cart) {
        //System.out.println(cart.getCartItems().get(0).getQuantity());
        Optional<Discount> discount = discountList.stream()
                .filter(discount1 -> discount1.isAcceptable(cart))
                .findFirst();

        for (CartItem carItem:cart.getCartItems()
             ) {
            discount.ifPresent(d->price=d.applyDiscount(carItem));
        }

        return price;
    }
}
