package com.example.tickets;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TicketsRepository extends JpaRepository<Tickets, Long> {
    @Query("SELECT p FROM Tickets p WHERE CONCAT(p.first_name, ' ', p.last_name, ' ', p.seat) LIKE %?1%")
    List<Tickets> search(String keyword);
}
