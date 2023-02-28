package com.example.tickets;

import java.util.List;

import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller; // Позволяет указать адрес страницы
import org.springframework.ui.Model; // Интерфейс, который необходим для взаимодействия Controller и конфигуратора modelviewcontroller, а также для добавления всех элементов web интерфейса
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView; // Метод позволяющий указать название html страниц, которые мы подвязываем к нашему модулю

import javax.naming.AuthenticationException;

@Controller
public class AppController {

    private final TicketsService service;

    private final FlightsService service2;
    private StripeService paymentsService;


    public AppController(TicketsService service, FlightsService service2) {
        this.service = service;
        this.service2 = service2;
    }

    @RequestMapping("/") // "/" - означает, что будет открываться главная страница
    public String viewHomePage(Model model, @Param("keyword") String keyword, @Param("keyword2") String keyword2){
        List<Tickets> listTickets = service.listAll(keyword);
        model.addAttribute("listTickets", listTickets);
        model.addAttribute("keyword", keyword);
        List<Flights> listFlights = service2.listAll(keyword2);
        model.addAttribute("listFlights", listFlights);
        model.addAttribute("keyword2", keyword2);
        model.addAttribute("amount", 50 * 100); // in cents
        model.addAttribute("stripePublicKey", "pk_test_51MfYMZLhnuHRDUyTUSOn9l7Nm6RQIv57J8nf5hgC5sORtCvEMA2iIhUXsBoIku42lcPwFHkVnwU8iI1QItI9gDzS00TETXEk8C");
        model.addAttribute("currency", "EUR");
        return "index"; // Возвращение html страницы
    }

    @RequestMapping("/user") // "/" - означает, что будет открываться главная страница
    public String viewUserPage(Model model, @Param("keyword") String keyword, @Param("keyword2") String keyword2){
        List<Tickets> listTickets = service.listAll(keyword);
        model.addAttribute("listTickets", listTickets);
        model.addAttribute("keyword", keyword);
        List<Flights> listFlights = service2.listAll(keyword2);
        model.addAttribute("listFlights", listFlights);
        model.addAttribute("keyword2", keyword2);
        return "user"; // Возвращение html страницы
    }

    @RequestMapping("/new") // Контроллер по добавлению билета
    public String showNewTicketsForm(Model model){
        Tickets tickets = new Tickets();
        model.addAttribute("tickets", tickets); // Первый параметр название database
        return "new_tickets"; // Возвращение html страницы
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveTickets(@ModelAttribute("tickets") Tickets tickets){
        service.save(tickets);
        return "redirect:/user"; // Сохранение и перенос на главную страницу
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditTicketsForm(@PathVariable(name = "id") Long id) { // id - параметр из браузерной строки
        ModelAndView mav = new ModelAndView("edit_tickets");
        Tickets tickets = service.get(id);
        mav.addObject("tickets", tickets);
        return mav; // Возвращаем страницу с данными о книге по id
    }

    @RequestMapping("/delete/{id}")
    public String deleteTickets(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:/user"; // Сохранение и перенос на главную страницу
    }

    @RequestMapping("/admin") // "/" - означает, что будет открываться главная страница
    public String viewAdminPage(Model model, @Param("keyword2") String keyword2){
        List<Flights> listFlights = service2.listAll(keyword2);
        model.addAttribute("listFlights", listFlights);
        model.addAttribute("keyword2", keyword2);
        return "admin"; // Возвращение html страницы
    }


    @RequestMapping("/new2") // Контроллер по добавлению билета
    public String showNewFlightsForm(Model model){
        Flights flights = new Flights();
        model.addAttribute("flights", flights); // Первый параметр название database
        return "new_flights"; // Возвращение html страницы
    }

    @RequestMapping(value = "/save2", method = RequestMethod.POST)
    public String saveFlights(@ModelAttribute("flights") Flights flights){
        service2.save(flights);
        return "redirect:/admin"; // Сохранение и перенос на главную страницу
    }

    @RequestMapping("/edit2/{id}")
    public ModelAndView showEditFlightsForm(@PathVariable(name = "id") Long id) { // id - параметр из браузерной строки
        ModelAndView mav = new ModelAndView("edit_flights");
        Flights flights = service2.get(id);
        mav.addObject("flights", flights);
        return mav; // Возвращаем страницу с данными о книге по id
    }

    @RequestMapping("/delete2/{id}")
    public String deleteFlights(@PathVariable(name = "id") Long id){
        service2.delete(id);
        return "redirect:/admin"; // Сохранение и перенос на главную страницу
    }

    @RequestMapping("/histogram") // Контроллер по открытию гистограммы
    public String showNewHistogramForm(Model model){
        Tickets tickets = new Tickets();
        model.addAttribute("tickets", tickets); // Первый параметр название database
        return "histogram"; // Возвращение html страницы
    }
    @RequestMapping("/author")
    public String showAuthorForm(){
        return "author"; // Возвращение html страницы
    }

    @RequestMapping("/result2")
    public String showResult2Form(){
        return "result2"; // Возвращение html страницы
    }




}
