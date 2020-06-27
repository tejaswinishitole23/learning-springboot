package com.ms.eqr.learningspringboot.data.controller;

import com.ms.eqr.learningspringboot.data.entity.Guest;
import com.ms.eqr.learningspringboot.data.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestRepository guestRepository;

    @GetMapping
    public List<Guest> getGuests() {
        return (List<Guest>) this.guestRepository.findAll();
    }
}
