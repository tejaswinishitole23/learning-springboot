package com.ms.eqr.learningspringboot.data.controller;

import com.ms.eqr.learningspringboot.data.entity.Guest;
import com.ms.eqr.learningspringboot.data.entity.Reservation;
import com.ms.eqr.learningspringboot.data.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping
    public List<Reservation> getReservations() {
        return (List<Reservation>) this.reservationRepository.findAll();
    }
}
