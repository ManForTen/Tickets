package com.example.tickets.Repository;

import java.util.List;

import com.example.tickets.Domain.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * The interface that is needed to search for tickets by first name, last name and seat
 * @author Artem Petrikov
 */
@Repository
public interface TicketsRepository extends JpaRepository<Tickets, Long> {
    @Query("SELECT p FROM Tickets p WHERE CONCAT(p.ticket_number, ' ', p.ticket_class, ' ', p.first_name, ' ', p.last_name, ' ', p.departure_datetime_f, ' ', p.arrival_datetime_f, ' ', p.price, ' ', p.seat) LIKE %?1%")
    List<Tickets> search(String keyword);
}
