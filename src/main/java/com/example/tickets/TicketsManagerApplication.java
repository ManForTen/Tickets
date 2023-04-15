package com.example.tickets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Class for running a web application
 * @author Artem Petrikov
 */
@SpringBootApplication
public class TicketsManagerApplication extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(TicketsManagerApplication.class, args); // Launching a web application
    }
}
