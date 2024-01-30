package com.example.sprintrabbitmq.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.sprintrabbitmq.util.Trace;

import org.springframework.amqp.core.Queue;


@RestController
@RequestMapping("/kafka")
public class KafkaController {

    
    @Value("${spring.kafka.topic}")
    private String kafkaTopic;

    @Value("${spring.kafka.host}")
    private String kafkaHost;

    @Value("${spring.kafka.groupid}")
    private String kafkaGroupId;


    @Autowired
    private MessageProducer messageProducer;

    @GetMapping("/sendform")
    public String sendFormWithParam(@RequestParam String message) {

        Trace.info("[RabbitMQController] *******************************************");
        Trace.info("[RabbitMQController] send message = "+ message);
        Trace.info("[RabbitMQController] host = "+ kafkaHost);
        Trace.info("[RabbitMQController] topic = "+ kafkaTopic);
        Trace.info("[RabbitMQController] groupid = "+ kafkaGroupId);
        messageProducer.sendMessage(kafkaTopic, message);
        return "Message sent to the RabbitMQ Successfully";
        
        
    }


}
