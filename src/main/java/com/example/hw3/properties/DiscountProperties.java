package com.example.hw3.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "discount")
@Data
public class DiscountProperties {
    private double deliveryFee;
    private double deliveryFeeLimit;
    private double discountPercentage;
    private int creditCartCommission;
}