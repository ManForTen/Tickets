package com.example.tickets.Controller;

import java.util.List;

import com.example.tickets.Domain.ChargeRequest;
import com.example.tickets.Domain.Flights;
import com.example.tickets.Domain.Tickets;
import com.example.tickets.Service.FlightsService;
import com.example.tickets.Service.TicketsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller; // Allows to specify the page address
import org.springframework.ui.Model; // The interface that is necessary for the interaction of the Controller and the modelviewcontroller configurator, as well as for adding all elements of the web interface
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView; // A method that allows you to specify the name of the html pages that we link to our module

/**
 * Controller for the application
 * @author Artem Petrikov
 */
@Controller
public class AppController {


    private final TicketsService service;

    private final FlightsService service2;

    /**
     * Method for calling services
     * @param service is a TicketsService for interacting with tickets
     * @param service2 is a FlightsService for interacting with flights
     */
    public AppController(TicketsService service, FlightsService service2) {
        this.service = service;
        this.service2 = service2;
    }

    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey; // The public key that is required for payment


    /**
     * The method required to display the main page
     * @param model required to add attributes
     * @param keyword this parameter from the TicketsRepository class is required to implement the search
     * @param keyword2 this parameter from the FlightRepository class is required to implement the search
     * @return index.html with all parameters
     */
    @RequestMapping("/") // "/" - means that the main page will open
    public String viewHomePage(Model model, @Param("keyword") String keyword, @Param("keyword2") String keyword2){
        List<Tickets> listTickets = service.listAll(keyword);
        model.addAttribute("listTickets", listTickets);
        model.addAttribute("keyword", keyword);
        List<Flights> listFlights = service2.listAll(keyword2);
        model.addAttribute("listFlights", listFlights);
        model.addAttribute("keyword2", keyword2);
        return "index"; // Returning the html page
    }

    /**
     * The method required to display the user page
     * @param model required to add attributes
     * @param keyword this parameter from the TicketsRepository class is required to implement the search
     * @param keyword2 this parameter from the FlightRepository class is required to implement the search
     * @return user/.html with all parameters
     */
    @RequestMapping("/user") // "/user" - means that the user page will open
    public String viewUserPage(Model model, @Param("keyword") String keyword, @Param("keyword2") String keyword2){
        List<Tickets> listTickets = service.listAll(keyword);
        model.addAttribute("listTickets", listTickets);
        model.addAttribute("keyword", keyword);
        List<Flights> listFlights = service2.listAll(keyword2);
        model.addAttribute("listFlights", listFlights);
        model.addAttribute("keyword2", keyword2);
        return "user"; // Returning the html page
    }

    /**
     * Controller for adding new ticket
     * @param model required to add attributes
     * @return new_tickets.html with all parameters
     */
    @RequestMapping("/new")
    public String showNewTicketsForm(Model model){
        Tickets tickets = new Tickets();
        model.addAttribute("tickets", tickets); // The first parameter is the name of the database
        return "new_tickets"; // Returning the html page
    }

    /**
     * Controller for saving ticket data
     * @param tickets required to add attributes to the database
     * @return the transfer to the user page
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTickets(@ModelAttribute("tickets") Tickets tickets){
        service.save(tickets);
        return "redirect:/user"; // Saving and transferring to the main page
    }

    /**
     * Controller for editing a ticket by id
     * @param id required to accurately indicate the attribute that needs to edit
     * @return page with ticket data by id
     */
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditTicketsForm(@PathVariable(name = "id") Long id) { // id - parameter from the browser line
        ModelAndView mav = new ModelAndView("edit_tickets");
        Tickets tickets = service.get(id);
        mav.addObject("tickets", tickets);
        return mav; // Returning the page with the ticket data by id
    }

    /**
     * Controller for deleting a ticket by id
     * @param id required to accurately indicate the attribute that needs to delete
     * @return the transfer to the user page
     */
    @RequestMapping("/delete/{id}")
    public String deleteTickets(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:/user"; // Saving and transferring to the user page
    }

    /**
     * Controller for displaying the admin page
     * @param model required to add attributes
     * @param keyword2 this parameter from the FlightRepository class is required to implement the search
     * @return admin.html with all parameters
     */
    @RequestMapping("/admin")
    public String viewAdminPage(Model model, @Param("keyword2") String keyword2){
        List<Flights> listFlights = service2.listAll(keyword2);
        model.addAttribute("listFlights", listFlights);
        model.addAttribute("keyword2", keyword2);
        return "admin"; // Returning the html page
    }

    /**
     * Controller for adding new flight
     * @param model required to add attributes
     * @return new_flights.html with all parameters
     */
    @RequestMapping("/new2")
    public String showNewFlightsForm(Model model){
        Flights flights = new Flights();
        model.addAttribute("flights", flights); // The first parameter is the name of the database
        return "new_flights"; // Returning the html page
    }

    /**
     * Controller for saving flight data
     * @param flights required to add attributes to the database
     * @return the transfer to the admin page
     */
    @RequestMapping(value = "/save2", method = RequestMethod.POST)
    public String saveFlights(@ModelAttribute("flights") Flights flights){
        service2.save(flights);
        return "redirect:/admin"; // Saving and transferring to the admin page
    }

    /**
     * Controller for editing a flight by id
     * @param id required to accurately indicate the attribute that needs to edit
     * @return page with flight data by id
     */
    @RequestMapping("/edit2/{id}")
    public ModelAndView showEditFlightsForm(@PathVariable(name = "id") Long id) { // id - parameter from the browser line
        ModelAndView mav = new ModelAndView("edit_flights");
        Flights flights = service2.get(id);
        mav.addObject("flights", flights);
        return mav; // Returning the page with the ticket data by id
    }

    /**
     * Controller for deleting a flight by id
     * @param id required to accurately indicate the attribute that needs to delete
     * @return the transfer to the admin page
     */
    @RequestMapping("/delete2/{id}")
    public String deleteFlights(@PathVariable(name = "id") Long id){
        service2.delete(id);
        return "redirect:/admin"; // Saving and transferring to the admin page
    }

    /**
     * Controller for opening the page with a histogram
     * @param model required to add attributes
     * @param keyword2 this parameter from the FlightRepository class is necessary to declare the table through which the histogram will be created
     * @return histogram.html with all parameters
     */
    @RequestMapping("/histogram")
    public String showNewHistogramForm(Model model, @Param("keyword") String keyword2){
        List<Flights> listFlights = service2.listAll(keyword2);
        model.addAttribute("listFlights", listFlights);
        model.addAttribute("keyword2", keyword2);
        return "histogram"; // Returning the html page
    }

    /**
     * Controller for opening the page about the author
     * @return author.html with all parameters
     */
    @RequestMapping("/author")
    public String showAuthorForm(){
        return "author"; // Returning the html page
    }

    /**
     * Controller for saving data about the name and surname of the person who is booking a ticket
     * @param tickets required to add attributes to the database
     * @return the transfer to the payment page
     */
    @RequestMapping(value = "/save3/{id}", method = RequestMethod.POST)
    public String savePayTickets(@ModelAttribute("tickets") Tickets tickets){
        service.save(tickets);
        return "redirect:/payment/{id}"; // Saving and transferring to the payment page
    }

    /**
     * Controller to go to the page for filling in the name and surname to buy the ticket
     * @param id required to accurately indicate the attribute that needs to buy
     * @return page with ticket data by id
     */
    @RequestMapping("/edit3/{id}")
    public ModelAndView showEditPayTicketsForm(@PathVariable(name = "id") Long id) { // id - parameter from the browser line
        ModelAndView mav = new ModelAndView("edit_pay");
        Tickets tickets = service.get(id);
        mav.addObject("tickets", tickets);
        return mav; // Returning the page with the ticket data by id
    }

    /**
     * Controller for displaying the ticket payment page
     * @param model required to add attributes
     * @param id required to accurately indicate the attribute that was purchased
     * @return page with ticket data by id
     */
    @RequestMapping("/payment/{id}")
    public ModelAndView showPaymentForm(Model model, @PathVariable(name = "id") Long id){ // id - parameter from the browser line
        ModelAndView mav = new ModelAndView("payment");
        Tickets tickets = service.get(id);
        mav.addObject("tickets", tickets);
        model.addAttribute("amount", tickets.getPrice()); // Measured in cents
        model.addAttribute("stripePublicKey", stripePublicKey); // PublicKey for payment
        model.addAttribute("currency", ChargeRequest.Currency.EUR); // Choice of currency
        return mav; // Returning the page with the ticket data by id
    }
}
