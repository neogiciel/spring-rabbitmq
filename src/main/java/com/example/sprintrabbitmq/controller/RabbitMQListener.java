package com.example.sprintrabbitmq.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    @RabbitListener(queues = "quarkus.queue")
    public void processMessage(String message) {
        System.out.println("Received Message: " + message);
    }
}