package com.example.sprintrabbitmq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.amqp.core.Queue;


@RestController
public class RabbitMQController {

    
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    @GetMapping("/send")
    public String sendMessage() {
        String message = "Hello RabbitMQ!";
        rabbitTemplate.convertAndSend(queue.getName(), message);
        return "Message sent to the RabbitMQ Successfully";
    }


    @GetMapping("/sendparam/{id}")
    public String sendMessageWithParam(@PathVariable String id) {
        String message = "Message "+ id;
        rabbitTemplate.convertAndSend(queue.getName(), message);
        return "Message sent to the RabbitMQ Successfully";
    }
}