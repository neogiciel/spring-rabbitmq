package com.example.sprintrabbitmq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sprintrabbitmq.util.Trace;

import org.springframework.amqp.core.Queue;


@RestController
public class RabbitMQController {

    
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    @GetMapping("/test")
    public String test() {
        Trace.info("[RabbitMQController] test");
        return "Test";
    }

    @GetMapping("/hello")
    public String hello(){
      return "12345678";
    }
  

    @GetMapping("/send")
    public String sendMessage() {
        Trace.info("[RabbitMQController] send messge");

        String message = "Hello RabbitMQ!";
        rabbitTemplate.convertAndSend(queue.getName(), message);
        return "Message sent to the RabbitMQ Successfully";
    }


    @GetMapping("/sendparam/{id}")
    public String sendMessageWithParam(@PathVariable String id) {
        Trace.info("[RabbitMQController] send messge with id = "+ id);
        String message = "Message "+ id;
        rabbitTemplate.convertAndSend(queue.getName(), message);
        return "Message sent to the RabbitMQ Successfully";
    }
}