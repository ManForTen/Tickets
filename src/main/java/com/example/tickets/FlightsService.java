package com.example.tickets;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightsService {

    private final FlightsRepository repo2;

    public FlightsService(FlightsRepository repo2) {
        this.repo2 = repo2;
    }

    public List<Flights> listAll(String keyword2){ //Коллекция и метод отвечающая за поиск и фильтр в нашей системе
        if (keyword2 != null){ // Если ключевое слово = null, то вызываем метод из первого return (вывод всех значений)
            return repo2.search(keyword2);
        }
        return repo2.findAll(); // Ничего не выведется
    }

    public void save(Flights flights){
        repo2.save(flights);
    }

    public Flights get(Long id){
        return repo2.findById(id).get();
    }

    public void delete(Long id){
        repo2.deleteById(id);
    }
}

