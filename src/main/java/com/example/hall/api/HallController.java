package com.example.hall.api;

import com.example.hall.model.Hall;
import com.example.hall.service.HallsService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hall")
@AllArgsConstructor
@NoArgsConstructor
public class HallController {

    @Autowired
    private HallsService cinemaService;

    @PostMapping
    public Hall createHall(@RequestBody Hall hall) {
        return cinemaService.addHall(hall);
    }

    @GetMapping
    public List<Hall> getAllHalls() {
        return cinemaService.getAll();
    }

    @GetMapping(path = "{hallId}")
    public Hall getHallById(@PathVariable(value = "hallId") UUID id) {
        Hall hall = cinemaService.getById(id);
        return hall;
    }

    @DeleteMapping(path = "{hallId}")
    public ResponseEntity<Void> deleteHall(@PathVariable(value = "hallId") UUID id)  {
        cinemaService.deleteHallById(id);
        return ResponseEntity.noContent().build();
    }

}
