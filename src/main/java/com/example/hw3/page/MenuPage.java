package com.example.hw3.page;


import com.example.hw3.demo;
import com.example.hw3.model.Product;
import com.example.hw3.model.cart.Cart;
import com.example.hw3.model.cart.CartItem;
import com.example.hw3.model.categories.Categories;
import com.example.hw3.model.categories.MainCategory;
import com.example.hw3.model.categories.SubCategory;
import com.example.hw3.model.checkout.Bill;
import com.example.hw3.model.enums.PageType;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class MenuPage {

    private final Scanner scanner;
    private final CheckoutPage checkoutPage;
    private final PaymentPage paymentPage;
    private Product product;
    private final Cart cart;
    //private final PageFactory pageFactory;// final olmalı ama final olunca cycle oluşuyor
    private Bill bill;

    /*@Override
    public PageType getType() {
        return PageType.MENU;
    }*/

    public void run(Categories categories) {

        List<MainCategory> mainCategoryList=categories.getMainCategoryList();
        System.out.println("---MAIN MENU---");
        for (MainCategory item:mainCategoryList)
        {
            System.out.println(item.getMainName());
        }
        System.out.print("PLEASE SELECT CATEGORY: ");
        String category=scanner.nextLine();

       for (MainCategory item:mainCategoryList) {
               if(item.getMainName().equals(category)){
                   for (SubCategory iter:item.getSubCategoryList()) {
                       System.out.println(iter.getSubName());
                   }
               }
        }


        System.out.print("PLEASE SELECT SUBCATEGORY: ");
        String subCategory=scanner.nextLine();



        for (MainCategory item:mainCategoryList) {
            int i=0;
            if(item.getMainName().equals(category)){
                for (SubCategory iter:item.getSubCategoryList()) {
                    if(iter.getSubName().equals(subCategory)){
                        for (Product product:iter.getProductList()) {
                            System.out.println(product.getName()+"  : "+i);
                            i++;
                        }
                    }
                }
            }
        }

        System.out.print("PLEASE SELECT PRODUCT: ");
        int pr=Integer.parseInt(scanner.nextLine());

      for (MainCategory item:mainCategoryList) {
            if(item.getMainName().equals(category)){
                for (SubCategory iter:item.getSubCategoryList()){
                    if(iter.getSubName().equals(subCategory)){
                        System.out.println("Product Description: "+iter.getProductList().get(pr).getDescription());
                        product=iter.getProductList().get(pr);

                    }
                }
            }
        }

        System.out.print("HOW MANY: ");
        int quantity =Integer.parseInt(scanner.nextLine());


        CartItem cartItem=CartItem.builder()
                .product(product)
                .quantity(quantity)
                .build();
        cart.addItem(cartItem);

        System.out.print("Please select page [FIRST PAGE,CHECKOUT]: ");

        String option=scanner.nextLine();
        if(option.equals("FIRST PAGE")){
            this.run(categories);
        }
        else if(option.equals("CHECKOUT")){
            bill =checkoutPage.run(cart);

        }

        System.out.print("Please select page [FIRST PAGE,PAYMENT]: ");

        String option1=scanner.nextLine();
        if(option1.equals("FIRST PAGE")){
            this.run(categories);
        }
        else if(option1.equals("PAYMENT")){
            paymentPage.run(bill);
        }



    }


}
