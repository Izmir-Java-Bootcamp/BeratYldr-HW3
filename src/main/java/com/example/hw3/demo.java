package com.example.hw3;

import com.example.hw3.page.*;
import com.example.hw3.model.Product;
import com.example.hw3.model.categories.Categories;
import com.example.hw3.model.categories.MainCategory;
import com.example.hw3.model.categories.SubCategory;
import com.example.hw3.model.enums.PageType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class demo implements CommandLineRunner {
    private final Scanner scanner;
    private final MenuPage menuPage;
    private final SearchPage searchPage;

    @Override
    public void run(String... args) throws Exception {

        //---MAKE PRODUCT AND ADD CATEGORİES--//
        Product p=Product.builder().name("Apple").price(10).description("test").build();
        Product p1=Product.builder().name("Pear").price(12).description("test").build();
        Product p4=Product.builder().name("Pear").price(12).description("test").build();
        Product p2=Product.builder().name("Tomato").price(15).description("test").build();
        Product p3=Product.builder().name("Lays").price(2000).description("test").build();

        SubCategory s=new SubCategory("F","Fruit");
        s.addProduct(p);
        s.addProduct(p1);
        s.addProduct(p4);
        SubCategory s1=new SubCategory("F","Vegetables");
        s1.addProduct(p2);
        SubCategory s2=new SubCategory("S","Chips");
        s2.addProduct(p3);
        MainCategory m=new MainCategory("F");
        m.addCategory(s);
        m.addCategory(s1);
        MainCategory m1=new MainCategory("S");
        m1.addCategory(s2);
        Categories categories=new Categories();
        categories.addCategory(m);
        categories.addCategory(m1);

        System.out.print("Please select page  "+ Arrays.toString(PageType.values())+" : ");
        String pageType= scanner.nextLine();

        if(pageType.equals("MENU")){
            menuPage.run(categories);
        }else{
            searchPage.run(categories);
        }


    }


}
