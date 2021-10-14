package com.example.hw3.model.cart;

import com.example.hw3.model.Product;
import com.example.hw3.service.discount.Discount;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartItem {
    private Product product;
    private int quantity;

    public double getPrice() {
        return product.getPrice() * quantity;
    }


}