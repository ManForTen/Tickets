package com.example.tickets.Service;

import com.example.tickets.Domain.Flights;
import com.example.tickets.Repository.FlightsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class represents a service that performs various operations on data.
 * It includes methods for search, save, get and deleting data.
 * @author Artem Petrikov
 */
@Service
public class FlightsService {

    private final FlightsRepository repo2;

    /**
     * Method for calling service
     * @param repo2 is a FlightsRepository for interacting with flights
     */
    public FlightsService(FlightsRepository repo2) {
        this.repo2 = repo2;
    }

    /**
     * Collection and method responsible for search and filter in the system
     * @param keyword2 this parameter from the FlightRepository class is required to implement the search
     * @return If the keyword = null, then call the method from the first return (output all values), otherwise nothing will be output
     */
    public List<Flights> listAll(String keyword2){
        if (keyword2 != null){
            return repo2.search(keyword2);
        }
        return repo2.findAll();
    }

    /**
     * Method for saving
     * @param flights required to add attributes to the database
     */
    public void save(Flights flights){
        repo2.save(flights);
    }

    /**
     * Method for getting data by id
     * @param id required to accurately indicate the attribute that needs to show
     * @return data by id
     */
    public Flights get(Long id){
        return repo2.findById(id).get();
    }

    /**
     * Method for deleting data by id
     * @param id required to accurately indicate the attribute that needs to delete
     */
    public void delete(Long id){
        repo2.deleteById(id);
    }
}

