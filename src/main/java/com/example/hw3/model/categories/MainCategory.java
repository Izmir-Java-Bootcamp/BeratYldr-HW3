package com.example.hw3.model.categories;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MainCategory extends Categories {
    private String mainName;
    private List<SubCategory> subCategoryList=new ArrayList<>();

    public MainCategory(String mainName) {
        this.mainName = mainName;
    }

    public void addCategory(SubCategory subCategory) {
        subCategoryList.add(subCategory);
    }



}
