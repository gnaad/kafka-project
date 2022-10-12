package com.gnanendraprasadp.kafkaproject.kafka.consumer;

import com.gnanendraprasadp.kafkaproject.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonConsumer.class);

    @KafkaListener(topics = "premiumUsers",groupId = "premiumUsers")
    public void consume(User user){
        LOGGER.info(String.format("Json message -> %s",user.toString()));
    }
}
