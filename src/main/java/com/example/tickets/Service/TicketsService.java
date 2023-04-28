package com.example.tickets.Service;

import com.example.tickets.Domain.Tickets;
import com.example.tickets.Repository.TicketsRepository;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * This class represents a service that performs various operations on data.
 * It includes methods for search, save, get and deleting data.
 * @author Artem Petrikov
 */
@Service
public class TicketsService {

    private final TicketsRepository repo;

    /**
     * Method for calling service
     * @param repo is a TicketsRepository for interacting with tickets
     */
    public TicketsService(TicketsRepository repo) {
        this.repo = repo;
    }

    /**
     * Collection and method responsible for search and filter in the system
     * @param keyword this parameter from the TicketsRepository class is required to implement the search
     * @return If the keyword = null, then call the method from the first return (output all values), otherwise nothing will be output
     */
    public List<Tickets> listAll(String keyword){
        if (keyword != null){
            return repo.search(keyword);
        }
        return repo.findAll();
    }

    /**
     * Method for saving
     * @param tickets required to add attributes to the database
     */
    public void save(Tickets tickets){
        repo.save(tickets);
    }

    /**
     * Method for getting data by id
     * @param id required to accurately indicate the attribute that needs to show
     * @return data by id
     */
    public Tickets get(Long id){
        return repo.findById(id).get();
    }

    /**
     * Method for deleting data by id
     * @param id required to accurately indicate the attribute that needs to delete
     */
    public void delete(Long id){
        repo.deleteById(id);
    }
}

