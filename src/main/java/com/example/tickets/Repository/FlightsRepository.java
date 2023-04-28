package com.example.tickets.Repository;

import java.util.List;

import com.example.tickets.Domain.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * The interface that is needed to search for flights by all param
 * @author Artem Petrikov
 */
@Repository
public interface FlightsRepository extends JpaRepository<Flights, Long> {
    @Query("SELECT p FROM Flights p WHERE CONCAT(p.id, ' ', p.aircraft_model,' ', p.departure_datetime, ' ', p.arrival_datetime, ' ', p.count_free_seats, ' ', p.place_fr, ' ', p.place_to, ' ', p.price, ' ', p.price_b) LIKE %?1%")
    List<Flights> search(String keyword2);
}
