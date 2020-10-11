package com.example.hall.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Data
@NoArgsConstructor
public final class Hall {

    @Id
    private UUID hallId;

    @Column(unique = true)
    private String name;

    private int linesNum;
    private int seatsNum;

    public Hall(String name, int linesNum, int seatsNum) {
        hallId = UUID.randomUUID();
        this.name = name;
        this.linesNum = linesNum;
        this.seatsNum = seatsNum;
    }

}
