package com.example.tickets.Config;

import org.springframework.context.annotation.Configuration; // Annotation for combining methods into a single springboot application
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry; // Annotation for combining methods into a single springboot application
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class for Spring MVC.
 * @author Artem Petrikov
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * Allows users to access the login page
     * @param registry is the ViewControllerRegistry object used to login the view controller.
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("login");
    }
}

