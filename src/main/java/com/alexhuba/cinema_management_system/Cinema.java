package com.alexhuba.cinema_management_system;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private int total_rows;
    private int total_columns;
    List<Seat> available_seats;
    @JsonIgnore
    List<Ticket> tickets;

    public Cinema(int total_rows, int total_columns, List<Seat> available_seats) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        this.available_seats = available_seats;
        this.tickets = new ArrayList<>();
    }

    public static List<Seat> populateCinema(int total_rows, int total_columns) {
        List<Seat> seatList = new ArrayList<>();
        for(int r = 1; r <= total_columns; r++) {
            for(int c = 1; c <= total_columns; c++) {
                seatList.add(new Seat(r, c));
            }
        }
        return seatList;
    }

    //getters and setters
    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public List<Seat> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(List<Seat> available_seats) {
        this.available_seats = available_seats;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
