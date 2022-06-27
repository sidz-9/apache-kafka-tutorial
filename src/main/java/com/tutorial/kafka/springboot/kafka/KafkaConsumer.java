package com.tutorial.kafka.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    // create a subscriber method that subscribes to the topic
    @KafkaListener(topics = "aNewTopic", groupId = "myGroup")  // spring provides this annotation to subscribe to the topic
    public void consume(String message) {   // this method acts as a subscriber and subscribes to the "aNewTopic" topic
        // whenever producer sends a message to the topic, this method would receive the message from the topic

        LOGGER.info(String.format("Message received -> %s", message));
    }
}
