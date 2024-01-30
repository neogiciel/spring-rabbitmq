package com.example.sprintrabbitmq.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sprintrabbitmq.model.Message;
import com.example.sprintrabbitmq.service.BddManager;
import com.example.sprintrabbitmq.util.Trace;

@Component
public class RabbitMQListener {

    @Autowired
    BddManager bdd;

    @RabbitListener(queues = "quarkus.queue")
    public void processMessage(String message) {
        Trace.info("[RabbitMQListener] resception messge = "+message);
        bdd.addMessage(new Message(message));
        System.out.println("Received Message: " + message);
    }
}