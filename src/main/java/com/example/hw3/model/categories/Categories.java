package com.example.hw3.model.categories;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class Categories {
    private List<MainCategory> mainCategoryList=new ArrayList<>();

    public void addCategory(MainCategory mainCategory){
        mainCategoryList.add(mainCategory);
    }
}

