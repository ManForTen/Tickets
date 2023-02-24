package com.example.tickets;

import jakarta.persistence.Entity; // аннотация entity для указания на то, что класс является сущностью и относится к ORM JPA
import jakarta.persistence.GeneratedValue; // аннотация для работы сo столбцами в SQL
import jakarta.persistence.GenerationType; // класс, который отвечает за типы данных перечисления (метод identity)
import jakarta.persistence.Id; // для первичного ключа объекта

@Entity
public class Flights {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id; //ID
    private String aircraft_model; //
    private String departure_datetime; // Дата и время вылета
    private String arrival_datetime; //
    private Long count_free_seats; //
    private String place_fr; // Откуда
    private String place_to; // Куда
    private String price; //
    private String price_b;


    protected Flights(){
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getAircraft_model(){
        return aircraft_model;
    }

    public void setAircraft_model(String aircraft_model){
        this.aircraft_model = aircraft_model;
    }

    public String getDeparture_datetime(){
        return departure_datetime;
    }

    public void setDeparture_datetime(String departure_datetime){
        this.departure_datetime = departure_datetime;
    }

    public String getArrival_datetime(){
        return arrival_datetime;
    }

    public void setArrival_datetime(String arrival_datetime){
        this.arrival_datetime = arrival_datetime;
    }

    public Long getCount_free_seats(){
        return count_free_seats;
    }

    public void setCount_free_seats(Long count_free_seats){
        this.count_free_seats = count_free_seats;
    }
    public String getPlace_fr(){
        return place_fr;
    }

    public void setPlace_fr(String place_fr){
        this.place_fr = place_fr;
    }
    public String getPlace_to(){
        return place_to;
    }

    public void setPlace_to(String place_to){
        this.place_to = place_to;
    }

    public String getPrice(){
        return price;
    }

    public void setPrice(String price){
        this.price = price;
    }
    public String getPrice_b(){
        return price_b;
    }

    public void setPrice_b(String price_b){
        this.price_b = price_b;
    }



    @Override
    public String toString() {
        return "flights [id=" + id + ", aircraft_model=" + aircraft_model +", departure_datetime=" + departure_datetime + ", arrival_datetime=" + arrival_datetime + ", count_free_seats=" + count_free_seats + ", place_fr=" + place_fr + ", place_to=" + place_to + ", price=" + price + "]";
    }
}
