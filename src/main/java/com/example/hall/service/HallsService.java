package com.example.hall.service;

import com.example.hall.model.Hall;

import java.util.List;
import java.util.UUID;

public interface HallsService {
    Hall addHall(Hall hall);

    List<Hall> getAll();

    Hall getById(UUID id);

    Hall getByName(String name);

    void deleteHallById(UUID id);
}
