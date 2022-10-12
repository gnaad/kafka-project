package com.gnanendraprasadp.kafkaproject.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PremiumProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(PremiumProducer.class);
    private KafkaTemplate<String, String> kafkaTemplate;

    public PremiumProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        LOGGER.info(String.format("Message sent %s",message));
        kafkaTemplate.send("PremiumUsers", message);
    }
}
