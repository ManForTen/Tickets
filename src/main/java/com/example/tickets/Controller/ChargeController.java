package com.example.tickets.Controller;

import com.example.tickets.Domain.ChargeRequest;
import com.example.tickets.Service.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.AuthenticationException;

/**
 * Controller for ticket payment
 * @author Artem Petrikov
 */
@Controller
public class ChargeController {

    @Autowired
    private StripeService paymentsService;

    /**
     * Controller for displaying information about the completed payment
     * @param chargeRequest object
     * @param model required to add attributes
     * @return the result.html
     * @throws StripeException handles only Stripe-specific exceptions
     * @throws AuthenticationException For authentication
     */
    @PostMapping("/charge")
    public String charge(ChargeRequest chargeRequest, Model model)
            throws StripeException, AuthenticationException {
        chargeRequest.setDescription("Example charge");
        chargeRequest.setCurrency(ChargeRequest.Currency.EUR);
        Charge charge = paymentsService.charge(chargeRequest);
        model.addAttribute("id", charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        return "result";
    }

    /**
     * Error handler
     * @param model required to add attributes
     * @param ex required to add StripeException
     * @return result.html with all parameters
     */
    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result";
    }
}
