package com.example.tickets;

import lombok.Data;

/**
 * Entity for payment
 * @author Artem Petrikov
 */
@Data
public class ChargeRequest {

    public enum Currency {  // Currency
        EUR, USD;
    }
    private String description;  // Description
    private int amount;  // Amount
    private Currency currency;  // Currency
    private String stripeEmail;  // Email
    private String stripeToken;  // Token
}