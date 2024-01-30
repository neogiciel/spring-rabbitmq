package com.example.sprintrabbitmq.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.sprintrabbitmq.model.Message;
import com.example.sprintrabbitmq.service.BddManager;
import com.example.sprintrabbitmq.util.Trace;

@Component
public class MessageConsumer {

    //@Value("${spring.kafka.topic}")
    //private String[] kafkaTopic;

    //@Value("${spring.kafka.groupid}")
    //private String kafkaGrouId;

    @Autowired
    BddManager bdd;
    
    //@KafkaListener(topics = "my-topic", groupId = "my-group-id")
    @KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.groupid}")
    public void listen(String message) {
        Trace.info("[MessageConsumer] Received message: " + message);
        bdd.addMessage(new Message(message));
    }

}