package com.example.sprintrabbitmq.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.example.sprintrabbitmq.util.Trace;

@Component
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, String message) {
        Trace.info("[MessageProducer] topic: " + topic);
        Trace.info("[MessageProducer] message: " + message);
        //kafkaTemplate.send(topic, message);
    }

}