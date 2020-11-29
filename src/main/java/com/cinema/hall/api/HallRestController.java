package com.cinema.hall.api;

import com.cinema.hall.model.Hall;
import com.cinema.hall.service.HallsService;
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
public class HallRestController {

    @Autowired
    private HallsService hallService;

    @PostMapping
    public Hall createHall(@RequestBody Hall hall) {
        return hallService.addHall(hall);
    }

    @GetMapping
    public List<Hall> getAllHalls() {
        return hallService.getAll();
    }

    @GetMapping(path = "{hallId}")
    public Hall getHallById(@PathVariable(value = "hallId") UUID id) {
        Hall hall = hallService.getById(id);
        return hall;
    }

    @DeleteMapping(path = "{hallId}")
    public ResponseEntity<Void> deleteHall(@PathVariable(value = "hallId") UUID id)  {
        hallService.deleteHallById(id);
        return ResponseEntity.noContent().build();
    }

}
