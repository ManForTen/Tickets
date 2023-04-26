package com.example.tickets.Service;

import com.example.tickets.Domain.ChargeRequest;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is required for payment
 * @author Artem Petrikov
 */
@Service
public class StripeService {

    @Value("${STRIPE_SECRET_KEY}") // Secret key for payment
    private String secretKey;

    /**
     * This method initializes the Stripe API key with the provided secret key.
     * It is annotated with @PostConstruct to ensure that it is called after all dependencies have been injected.
     * This method sets the static apiKey field of the Stripe class to the provided secret key.
     * This allows the application to make authenticated requests to the Stripe API.
     */
    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }

    /**
     * This method charges a customer using the Stripe API
     * @param chargeRequest contains the data necessary to charge the money
     * @return Charge.create(chargeParams) method with these parameters to create and process the charge.
     * @throws AuthenticationException needed for errors related to authentication
     * @throws StripeException needed for errors related to Stripe API
     */
    public Charge charge(ChargeRequest chargeRequest)
            throws AuthenticationException, StripeException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", chargeRequest.getCurrency());
        chargeParams.put("description", chargeRequest.getDescription());
        chargeParams.put("source", chargeRequest.getStripeToken());
        return Charge.create(chargeParams);
    }
}