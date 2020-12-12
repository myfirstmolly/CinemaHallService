package com.cinema.hall.rabbitmq;

import com.cinema.hall.model.Hall;
import com.cinema.hall.service.HallsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    HallsService hallsService;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consume(Hall hall) {
        hallsService.addHall(hall);
    }
}