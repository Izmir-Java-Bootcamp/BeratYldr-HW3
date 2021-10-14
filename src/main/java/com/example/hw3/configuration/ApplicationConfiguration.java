package com.example.hw3.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public Scanner scanner() {return new Scanner(System.in);
    }
}