package com.example.tickets;

import jakarta.persistence.Entity; // аннотация entity для указания на то, что класс является сущностью и относится к ORM JPA
import jakarta.persistence.GeneratedValue; // аннотация для работы сo столбцами в SQL
import jakarta.persistence.GenerationType; // класс, который отвечает за типы данных перечисления (метод identity)
import jakarta.persistence.Id; // для первичного ключа объекта

@Entity
public class Tickets {
    private Long id; //ID
    private String first_name; // Имя пассажира
    private String last_name; // Фамилия пассажира
    private String booking_date; // Дата и время бронирования
    private String departure_date; // Дата и время вылета
    private String board_date; // Дата и время приземления
    private String place_fr; // Откуда
    private String place_to; // Куда
    private String seat; // Посадочное место

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

    public String getBooking_date(){
        return booking_date;
    }

    public void setBooking_date(String booking_date){
        this.booking_date = booking_date;
    }

    public String getDeparture_date(){
        return departure_date;
    }

    public void setDeparture_date(String departure_date){
        this.departure_date = departure_date;
    }

    public String getBoard_date(){
        return board_date;
    }

    public void setBoard_date(String board_date){
        this.board_date = board_date;
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

    public String getSeat(){
        return seat;
    }

    public void setSeat(String seat){
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "tickets [id=" + id + ", first_name=" + first_name +", last_name=" + last_name + ", booking_date=" + booking_date + ", departure_date=" + departure_date + ", board_date=" + board_date + ", place_fr=" + place_fr + ", place_to=" + place_to + ", seat=" + seat +"]";
    }
}
