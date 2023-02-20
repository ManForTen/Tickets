package com.example.tickets;

import org.springframework.context.annotation.Configuration; // Аннотация для объединения методов в одно springboot приложение
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry; // Аннотация для объединения методов в одно springboot приложение
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
    }
}

