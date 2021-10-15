package com.example.hw3.page;

import com.example.hw3.model.cart.Cart;
import com.example.hw3.model.categories.Categories;
import com.example.hw3.model.checkout.Bill;
import com.example.hw3.service.CheckoutService;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Data
public class CheckoutPage {
    private  final CheckoutService checkoutService;
    private final Scanner scanner;
    private MenuPage menuPage;
    private final PaymentPage paymentPage;
    private  Bill bill;

    public void run(Cart cart, Categories categories) {

        bill=checkoutService.checkout(cart);
        System.out.print("Please select page [FIRST PAGE,PAYMENT]: ");

        String option1=scanner.nextLine();
        if(option1.equals("FIRST PAGE")){
            menuPage.run(categories);
            return;
        }
        else if(option1.equals("PAYMENT")){
            paymentPage.run(bill);
        }
    }


}
