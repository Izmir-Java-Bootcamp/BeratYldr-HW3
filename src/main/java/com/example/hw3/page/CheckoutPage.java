package com.example.hw3.page;

import com.example.hw3.model.cart.Cart;
import com.example.hw3.model.checkout.Bill;
import com.example.hw3.service.CheckoutService;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CheckoutPage {
    private  final CheckoutService checkoutService;

    public Bill run(Cart cart) {
           return checkoutService.checkout(cart);
    }


}
