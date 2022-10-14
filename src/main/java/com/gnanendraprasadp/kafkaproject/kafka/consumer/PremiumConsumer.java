package com.gnanendraprasadp.kafkaproject.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PremiumConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(PremiumConsumer.class);

    @KafkaListener(topics = "PremiumTopic", groupId = "premiumGroup")
    public void consumeData(String message) {
        LOGGER.info(String.format("Message received -> %s",message));
    }
}
