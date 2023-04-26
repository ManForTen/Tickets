package com.example.tickets.Domain;

import jakarta.persistence.Entity; // Entity annotation to indicate that the class is an entity and belongs to the ORM JPA
import jakarta.persistence.GeneratedValue; // Annotation for working with columns in SQL
import jakarta.persistence.GenerationType; // The class that is responsible for the enumeration data types (identity method)
import jakarta.persistence.Id; // Required for the primary key of the object


/**
 * Class for creating an entity
 * @author Artem Petrikov
 */
@Entity
public class Flights {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;  //ID
    private String aircraft_model;  // Aircraft model
    private String departure_datetime;  // Departure date and time
    private String arrival_datetime;  // Date and time of arrival
    private Long count_free_seats;  // Number of available seats
    private String place_fr;  // Where is the departure from
    private String place_to;  // Where the landing takes place
    private String price;  // Price for economy class
    private String price_b;  // Price for business class

    /**
     * Default protected constructor
     */
    public Flights(){
    }

    /**
     * Returns the unique flight identifier
     * @return id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId(){
        return id;
    }

    /**
     * Sets a unique flight identifier
     * @param id is a unique flight identifier
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * Returns an aircraft model
     * @return aircraft_model
     */
    public String getAircraft_model(){
        return aircraft_model;
    }

    /**
     * Sets the aircraft model
     * @param aircraft_model is a model aircraft
     */
    public void setAircraft_model(String aircraft_model){
        this.aircraft_model = aircraft_model;
    }

    /**
     * Returns the departure date and time
     * @return departure_datetime
     */
    public String getDeparture_datetime(){
        return departure_datetime;
    }

    /**
     * Sets the departure date and time
     * @param departure_datetime is a departure date and time
     */
    public void setDeparture_datetime(String departure_datetime){
        this.departure_datetime = departure_datetime;
    }

    /**
     * Returns the date and time of arrival
     * @return arrival_datetime
     */
    public String getArrival_datetime(){
        return arrival_datetime;
    }

    /**
     * Sets the date and time of arrival
     * @param arrival_datetime is a date and time of arrival
     */
    public void setArrival_datetime(String arrival_datetime){
        this.arrival_datetime = arrival_datetime;
    }

    /**
     * Returns the number of available seats
     * @return count_free_seats
     */
    public Long getCount_free_seats(){
        return count_free_seats;
    }

    /**
     * Sets the number of available seats
     * @param count_free_seats is a number of available seats
     */
    public void setCount_free_seats(Long count_free_seats){
        this.count_free_seats = count_free_seats;
    }

    /**
     * Returns where is the departure from
     * @return place_fr
     */
    public String getPlace_fr(){
        return place_fr;
    }

    /**
     * Sets where is the departure from
     * @param place_fr This is where the departure is from
     */
    public void setPlace_fr(String place_fr){
        this.place_fr = place_fr;
    }

    /**
     * Returns where the landing takes place
     * @return place_to
     */
    public String getPlace_to(){
        return place_to;
    }

    /**
     * Sets where the landing takes place
     * @param place_to This is where the landing takes place
     */
    public void setPlace_to(String place_to){
        this.place_to = place_to;
    }

    /**
     * Returns the price for economy class
     * @return price
     */
    public String getPrice(){
        return price;
    }

    /**
     * Sets the price for economy class
     * @param price is the price for economy class
     */
    public void setPrice(String price){
        this.price = price;
    }

    /**
     * Returns the price for business class
     * @return price_b
     */
    public String getPrice_b(){
        return price_b;
    }

    /**
     * Sets the price for business class
     * @param price_b is the price for business class
     */
    public void setPrice_b(String price_b){
        this.price_b = price_b;
    }

    /**
     * Returns a string representation of the plane flight object
     * @return string representation of the plane flight object
     */
    @Override
    public String toString() {
        return "flights [id=" + id + ", aircraft_model=" + aircraft_model +", departure_datetime=" + departure_datetime + ", arrival_datetime=" + arrival_datetime + ", count_free_seats=" + count_free_seats + ", place_fr=" + place_fr + ", place_to=" + place_to + ", price=" + price + ", price_b=" + price_b + "]";
    }
}
