package com.ms.eqr.learningspringboot.data.controller;

import com.ms.eqr.learningspringboot.data.entity.Room;
import com.ms.eqr.learningspringboot.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public List<Room> getRooms() {
        return (List<Room>) this.roomRepository.findAll();
    }
}
