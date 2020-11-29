package com.cinema.hall.model;

import com.cinema.hall.HallRequest;
import com.cinema.hall.HallResponse;
import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@EnableAutoConfiguration
@Entity
@Data
public final class Hall {

    @Id
    private UUID hallId;

    @Column(unique = true)
    private String name;

    private int linesNum;
    private int seatsNum;

    public Hall() {
        hallId = UUID.randomUUID();
    }

    public Hall(UUID hallId, String name, int linesNum, int seatsNum) {
        this.hallId = hallId;
        this.name = name;
        this.linesNum = linesNum;
        this.seatsNum = seatsNum;
    }

    public static Hall fromHallRequest(HallRequest hallRequest) {
        return new Hall(UUID.randomUUID(),
                hallRequest.getName(),
                hallRequest.getLinesNum(),
                hallRequest.getSeatsNum());
    }

    public HallResponse toHallResponse() {
        return HallResponse.newBuilder().
                setId(hallId.toString()).
                setLinesNum(linesNum).
                setSeatsNum(seatsNum).
                build();
    }

}
