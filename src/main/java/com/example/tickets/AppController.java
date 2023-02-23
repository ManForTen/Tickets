package com.example.tickets;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller; // Позволяет указать адрес страницы
import org.springframework.ui.Model; // Интерфейс, который необходим для взаимодействия Controller и конфигуратора modelviewcontroller, а также для добавления всех элементов web интерфейса
import org.springframework.web.bind.annotation.ModelAttribute; // Аннотация для связывания параметра и метода, который будет выводиться в web интерфейсе
import org.springframework.web.bind.annotation.PathVariable; // Аннотация необходимая для получения параметра из адресной строки браузера
import org.springframework.web.bind.annotation.RequestMapping; // Аннотация для создания адреса браузерной строки(URL) для создания адреса контроллера
import org.springframework.web.bind.annotation.RequestMethod; // Метод указывающий с помощью какого http запроса будем передавать данные (POST,GET)
import org.springframework.web.servlet.ModelAndView; // Метод позволяющий указать название html страниц, которые мы подвязываем к нашему модулю

@Controller
public class AppController {

    private final TicketsService service;

    private final FlightsService service2;

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
        return "index"; // Возвращение html страницы
    }

    @RequestMapping("/user") // "/" - означает, что будет открываться главная страница
    public String viewUserPage(Model model, @Param("keyword2") String keyword2){
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
        return "redirect:/"; // Сохранение и перенос на главную страницу
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
        return "redirect:/"; // Сохранение и перенос на главную страницу
    }

    @RequestMapping("/histogram") // Контроллер по открытию гистограммы
    public String showNewHistogramForm(Model model){
        Tickets tickets = new Tickets();
        model.addAttribute("tickets", tickets); // Первый параметр название database
        return "histogram"; // Возвращение html страницы
    }



}
