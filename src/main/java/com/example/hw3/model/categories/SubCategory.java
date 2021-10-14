package com.example.hw3.model.categories;

import com.example.hw3.model.Product;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SubCategory extends MainCategory{
    private String subName;
    private List<Product> productList=new ArrayList<>();

    public SubCategory(String mainName, String subName) {
        super(mainName);
        this.subName = subName;
    }

    public void addProduct(Product product){
        productList.add(product);
    }

}
