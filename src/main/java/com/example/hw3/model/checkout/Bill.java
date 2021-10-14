package com.example.hw3.model.checkout;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Bill {
    private List<BillItem> billItems;
    private double totalPrice;
}
