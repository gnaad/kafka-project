package com.gnanendraprasadp.kafkaproject.kafka.producer;

import com.gnanendraprasadp.kafkaproject.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonProducer {
    private KafkaTemplate<String, User> kafkaTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonProducer.class);

    public JsonProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User message) {
        LOGGER.info(String.format("Message is -> %s", message.toString()));
        Message<User> userMessage = MessageBuilder.withPayload(message).
                setHeader(KafkaHeaders.TOPIC, "premiumUsers").build();
        kafkaTemplate.send(userMessage);
    }
}
