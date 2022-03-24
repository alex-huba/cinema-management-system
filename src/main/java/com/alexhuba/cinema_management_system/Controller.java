package com.alexhuba.cinema_management_system;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/*
* Endpoints which handle requests from user
* 1) "/seats" shows all free seats in the cinema at the moment
* 2) "/purchase" lets user purchase the ticket
* 3) "/return" provides refund functionality
* 4) "/stats" gives an overlook about current situation in the cinema, i.e
*       - what is the current income
*       - how many seats are still available
*       - how many tickets were sold
* */

@RestController
public class Controller {
    Cinema myCinema = new Cinema(9, 9, Cinema.populateCinema(9,9));

    @GetMapping("/seats")
    public Cinema getAvailableSeats() {
        return myCinema;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseTicket(@RequestBody Seat seat) {
        if(seat.getRow() < 1 ||
                seat.getRow() > myCinema.getTotal_rows() ||
                seat.getColumn() < 1 ||
                seat.getColumn() > myCinema.getTotal_columns()) {
            return new ResponseEntity(Map.of("error", "The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
        }

        for(Seat s : myCinema.getAvailable_seats()) {
            if(s.getColumn() == seat.getColumn() && s.getRow() == seat.getRow()) {
                Ticket ticket = new Ticket(UUID.randomUUID(), s);
                myCinema.getTickets().add(ticket);
                myCinema.getAvailable_seats().remove(s);
                return new ResponseEntity<>(ticket, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(Map.of("error", "The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@RequestBody Token token) {
        for(Ticket t : myCinema.getTickets()) {
            if(Objects.equals(t.getToken(), token.getToken())) {
                myCinema.getTickets().remove(t);
                myCinema.getAvailable_seats().add(t.getTicket());
                return new ResponseEntity<>(Map.of("returned_ticket", t.getTicket()), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(Map.of("error", "Wrong token!"), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/stats")
    public ResponseEntity<?> showStats(@RequestParam(required = false) String password) {
        if(password != null && password.equals("super_secret")) {
            Map<String, Integer> stats = new HashMap<>();
            int current_income = calculateIncome();
            int number_of_available_seats = myCinema.getAvailable_seats().size();
            int number_of_purchased_tickets = myCinema.getTickets().size();
            stats.put("current_income", current_income);
            stats.put("number_of_available_seats", number_of_available_seats);
            stats.put("number_of_purchased_tickets", number_of_purchased_tickets);
            return new ResponseEntity<>(stats, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Map.of("error", "The password is wrong!"), HttpStatus.valueOf(401));
        }

    }

    private int calculateIncome() {
        int currentIncome = 0;
        for(Ticket t : myCinema.getTickets()) {
            currentIncome += t.getTicket().getPrice();
        }
        return currentIncome;
    }
}
