package com.example.tickets;

import java.util.HashMap;
import java.util.Map;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.net.RequestOptions;
import com.stripe.param.CustomerCreateParams;

public class StripeExample {

    public static void main(String[] args) {
        Stripe.apiKey = "sk_test_51MfYMZLhnuHRDUyTLzT0IbTWUqH9K6unxmeEpH8R5kczRKWSpXLhXNGPlOQY1q1fYiQMztEni9lnTtiCgLIMf1zl00BZNEuBPy";

        CustomerCreateParams params =
                CustomerCreateParams
                        .builder()
                        .setDescription("Example description")
                        .setEmail("test@example.com")
                        .setPaymentMethod("pm_card_visa")  // obtained via Stripe.js
                        .build();

        try {
            Customer customer = Customer.create(params);
            System.out.println(customer);
        } catch (StripeException e) {
            e.printStackTrace();
        }
    }
}