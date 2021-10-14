package com.example.hw3.page;

import com.example.hw3.model.categories.Categories;
import com.example.hw3.model.enums.PageType;


public interface Page {
     PageType getType();
     void run(Categories categories);
}
