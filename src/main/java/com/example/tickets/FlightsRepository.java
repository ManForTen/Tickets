package com.example.tickets;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * The interface that is needed to search for flights by aircraft model, number of available seats and ticket price
 * @author Artem Petrikov
 */
@Repository
public interface FlightsRepository extends JpaRepository<Flights, Long> {
    @Query("SELECT p FROM Flights p WHERE CONCAT(p.aircraft_model, ' ', p.count_free_seats, ' ', p.price, ' ', p.price_b) LIKE %?1%")
    List<Flights> search(String keyword2);
}
