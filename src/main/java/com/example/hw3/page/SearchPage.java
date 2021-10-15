package com.example.hw3.page;


import com.example.hw3.model.Product;
import com.example.hw3.model.cart.Cart;
import com.example.hw3.model.cart.CartItem;
import com.example.hw3.model.categories.Categories;
import com.example.hw3.model.categories.MainCategory;
import com.example.hw3.model.categories.SubCategory;
import com.example.hw3.model.checkout.Bill;
import com.example.hw3.model.enums.PageType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SearchPage{
    private final Scanner scanner;
    private Product product=null;
    private final Cart cart;
    private Bill bill;
    private final CheckoutPage checkoutPage;
    private final MenuPage menuPage;

    public void run(Categories categories) {
        int i = 0;
        do {
        System.out.print("SEARCH: ");
        String scan = scanner.nextLine();
        List<Product> productList = new ArrayList<>();
        List<MainCategory> mainCategoryList = categories.getMainCategoryList().stream().
                filter(mainCategory -> mainCategory.toString().contains(scan)).collect(Collectors.toList());


        for (MainCategory mainCategory : mainCategoryList) {
            for (SubCategory sub : mainCategory.getSubCategoryList()) {
                for (Product product : sub.getProductList()) {
                    if (product.getName().contains(scan)) {
                        System.out.println(product.getName() + ": " + i);
                        productList.add(product);
                        i++;
                    }
                }
            }
        }
        if (i > 0) {
            System.out.print("PLEASE SELECT PRODUCT: ");
            int pr = Integer.parseInt(scanner.nextLine());

            for (int j = 0; j < productList.size(); j++) {
                if (pr == j) {
                    System.out.println("Product Description: " + productList.get(j).getDescription());
                    product = productList.get(pr);
                }
            }
            if (product != null) {
                System.out.print("HOW MANY: ");
                int quantity = Integer.parseInt(scanner.nextLine());


                CartItem cartItem = CartItem.builder()
                        .product(product)
                        .quantity(quantity)
                        .build();
                cart.addItem(cartItem);

                System.out.print("Please select page [FIRST PAGE,CHECKOUT]: ");

                String option = scanner.nextLine();
                if (option.equals("FIRST PAGE")) {
                    menuPage.run(categories);
                    return;
                } else if (option.equals("CHECKOUT")) {
                    checkoutPage.run(cart, categories);

                }


            }
        }
    } while (i==0);
    }
    }

