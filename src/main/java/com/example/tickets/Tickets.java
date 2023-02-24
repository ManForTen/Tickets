package com.example.tickets;

import jakarta.persistence.*;

@Entity
public class Tickets {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id; //ID
    private String ticket_number; // Имя пассажира
    private String ticket_class; // Фамилия пассажира
    private String first_name; // Дата и время бронирования
    private String last_name; // Дата и время вылета
    private String departure_datetime_f; // Дата и время приземления
    private String arrival_datetime_f; // Откуда
    private Long price; // Куда
    private Long flights_id; //
    private String seat; // Откуда

    protected Tickets(){
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }


    public String getTicket_number(){
        return ticket_number;
    }

    public void setTicket_number(String ticket_number){
        this.ticket_number = ticket_number;
    }

    public String getTicket_class(){
        return ticket_class;
    }

    public void setTicket_class(String ticket_class){
        this.ticket_class = ticket_class;
    }
    public String getFirst_name(){
        return first_name;
    }

    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }

    public String getLast_name(){
        return last_name;
    }

    public void setLast_name(String last_name){
        this.last_name = last_name;
    }

    public String getDeparture_datetime_f(){
        return departure_datetime_f;
    }

    public void setDeparture_datetime_f(String departure_datetime_f){
        this.departure_datetime_f = departure_datetime_f;
    }

    public String getArrival_datetime_f(){
        return arrival_datetime_f;
    }

    public void setArrival_datetime_f(String arrival_datetime_f){
        this.arrival_datetime_f = arrival_datetime_f;
    }

    public Long getPrice(){
        return price;
    }

    public void setPrice(Long price){
        this.price = price;
    }
    public Long getFlights_id(){
        return flights_id;
    }

    public void setFlights_id(Long flights_id){
        this.flights_id = flights_id;
    }

    public String getSeat(){
        return seat;
    }

    public void setSeat(String seat){
        this.seat = seat;
    }



    @Override
    public String toString() {
        return "tickets [id=" + id + ", ticket_number=" + ticket_number +", ticket_class=" + ticket_class + ", first_name=" + first_name + ", last_name=" + last_name + ", departure_datetime_f=" + departure_datetime_f + ", arrival_datetime_f=" + arrival_datetime_f + ", price=" + price + ", flights_id=" + flights_id + ", seat=" + seat +"]";
    }
}
