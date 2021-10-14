package com.example.hw3.page;


import com.example.hw3.model.categories.Categories;
import com.example.hw3.model.enums.PageType;
import org.springframework.stereotype.Component;

@Component
public class SearchPage implements Page {


    @Override
    public PageType getType() {
        return PageType.SEARCH;
    }


    @Override
    public void run(Categories categories) {
        System.out.println("search menu");
    }



}
