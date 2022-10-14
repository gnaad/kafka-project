package com.gnanendraprasadp.kafkaproject.kafka.consumer;

import com.gnanendraprasadp.kafkaproject.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JSONConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JSONConsumer.class);

    @KafkaListener(topics = "JsonTopic", groupId = "premiumGroup")
    public void consumeData(User user) {
        LOGGER.info(String.format("JSON received -> %s",user.toString()));
    }
}
