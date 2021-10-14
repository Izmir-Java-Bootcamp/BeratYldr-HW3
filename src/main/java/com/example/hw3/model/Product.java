package com.example.hw3.model;

import lombok.Builder;
import lombok.Data;

import javax.management.modelmbean.DescriptorSupport;

@Data
@Builder
public class Product {
    private String name;
    private String description;
    private double price;
}
