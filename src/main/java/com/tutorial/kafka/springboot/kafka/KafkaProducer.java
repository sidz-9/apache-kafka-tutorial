package com.tutorial.kafka.springboot.kafka;

// A kafka Producer service

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    // creating a logger to log messages
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    // injecting Kafka Template in  this spring bean
    private KafkaTemplate<String, String> kafkaTemplate;

    // constructor based dependency injection
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // method that uses Kafka Template to send a message
    public void sendMessage(String message) {
        LOGGER.info(String.format("Message sent %s", message));
        kafkaTemplate.send("aNewTopic", message);
    }
}
