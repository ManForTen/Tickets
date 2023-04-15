package com.example.tickets;

import jakarta.persistence.Entity; // Entity annotation to indicate that the class is an entity and belongs to the ORM JPA
import jakarta.persistence.GeneratedValue; // Annotation for working with columns in SQL
import jakarta.persistence.GenerationType; // The class that is responsible for the enumeration data types (identity method)
import jakarta.persistence.Id; // Required for the primary key of the object

/**
 * Class for creating an entity
 * @author Artem Petrikov
 */
@Entity
public class Tickets {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id; // ID
    private String ticket_number; // Ticket number
    private String ticket_class; // Ticket class (Economy/Business)
    private String first_name; // Name
    private String last_name; // Last name
    private String departure_datetime_f; // Date and time of departure
    private String arrival_datetime_f; // Date and time of arrival
    private Long price; // Ticket price
    private Long flights_id; // Flight ID
    private String seat; // Seat

    /**
     * Default protected constructor
     */
    protected Tickets(){
    }

    /**
     * Returns the unique identifier of the ticket
     * @return id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId(){
        return id;
    }

    /**
     * Sets a unique ticket identifier
     * @param id this is the unique identifier of the ticket
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Returns the ticket number
     * @return ticket_number
     */
    public String getTicket_number(){
        return ticket_number;
    }

    /**
     * Sets the ticket number
     * @param ticket_number is the ticket number
     */
    public void setTicket_number(String ticket_number){
        this.ticket_number = ticket_number;
    }

    /**
     * Returns ticket class
     * @return ticket_class
     */
    public String getTicket_class(){
        return ticket_class;
    }

    /**
     * Sets ticket class
     * @param ticket_class is the ticket class
     */
    public void setTicket_class(String ticket_class){
        this.ticket_class = ticket_class;
    }

    /**
     * Returns the name of the passenger
     * @return first_name
     */
    public String getFirst_name(){
        return first_name;
    }

    /**
     * Sets the name of the passenger
     * @param first_name is the first name of the passenger
     */
    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }

    /**
     * Returns the last name of the passenger
     * @return last_name
     */
    public String getLast_name(){
        return last_name;
    }

    /**
     * Sets the last name of the passenger
     * @param last_name is the last name of the passenger
     */
    public void setLast_name(String last_name){
        this.last_name = last_name;
    }

    /**
     * Returns the date and time of departure
     * @return departure_datetime_f
     */
    public String getDeparture_datetime_f(){
        return departure_datetime_f;
    }

    /**
     * Sets the date and time of departure
     * @param departure_datetime_f is the date and time of departure
     */
    public void setDeparture_datetime_f(String departure_datetime_f){
        this.departure_datetime_f = departure_datetime_f;
    }

    /**
     * Returns the date and time of arrival
     * @return arrival_datetime_f
     */
    public String getArrival_datetime_f(){
        return arrival_datetime_f;
    }

    /**
     * Sets the date and time of arrival
     * @param arrival_datetime_f is the date and time of arrival
     */
    public void setArrival_datetime_f(String arrival_datetime_f){
        this.arrival_datetime_f = arrival_datetime_f;
    }

    /**
     * Returns the price of the ticket
     * @return price
     */
    public Long getPrice(){
        return price;
    }

    /**
     * Sets the price of the ticket
     * @param price is the price of the ticket
     */
    public void setPrice(Long price){
        this.price = price;
    }

    /**
     * Returns flights id
     * @return flights_id
     */
    public Long getFlights_id(){
        return flights_id;
    }

    /**
     * Sets flights ID
     * @param flights_id is the flight ID
     */
    public void setFlights_id(Long flights_id){
        this.flights_id = flights_id;
    }

    /**
     * Returns the seating position
     * @return seat
     */
    public String getSeat(){
        return seat;
    }

    /**
     * Sets the seating position
     * @param seat is the seating position
     */
    public void setSeat(String seat){
        this.seat = seat;
    }

    /**
     * Returns the string representation of the plane ticket object
     * @return string representation of the object of an airplane ticket
     */
    @Override
    public String toString() {
        return "tickets [id=" + id + ", ticket_number=" + ticket_number +", ticket_class=" + ticket_class + ", first_name=" + first_name + ", last_name=" + last_name + ", departure_datetime_f=" + departure_datetime_f + ", arrival_datetime_f=" + arrival_datetime_f + ", price=" + price + ", flights_id=" + flights_id + ", seat=" + seat +"]";
    }
}
