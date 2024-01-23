package com.example.sprintrabbitmq.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.sprintrabbitmq.util.Trace;

@Component
public class RabbitMQListener {

    @RabbitListener(queues = "quarkus.queue")
    public void processMessage(String message) {
        Trace.info("[RabbitMQListener] resception messge = "+message);
        System.out.println("Received Message: " + message);
    }
}