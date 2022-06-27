package com.tutorial.kafka.springboot.kafka;

import com.tutorial.kafka.springboot.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "aNewTopic_JSON", groupId = "myGroup")
    public void consume(User user) {    // Spring Kafka provided JsonDeserializer will convert User JSON object into Java User object
        LOGGER.info(String.format("JSON message received -> %s", user.toString()));
    }
}
