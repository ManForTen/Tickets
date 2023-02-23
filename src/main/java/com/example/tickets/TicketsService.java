package com.example.tickets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketsService {

    private final TicketsRepository repo;

    public TicketsService(TicketsRepository repo) {
        this.repo = repo;
    }

    public List<Tickets> listAll(String keyword){ //Коллекция и метод отвечающая за поиск и фильтр в нашей системе
        if (keyword != null){ // Если ключевое слово = null, то вызываем метод из первого return (вывод всех значений)
            return repo.search(keyword);
        }
        return repo.findAll(); // Ничего не выведется
    }

    public void save(Tickets tickets){
        repo.save(tickets);
    }

    public Tickets get(Long id){
        return repo.findById(id).get();
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}

