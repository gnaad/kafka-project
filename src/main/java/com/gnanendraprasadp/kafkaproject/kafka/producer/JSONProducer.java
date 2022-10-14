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
public class JSONProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JSONProducer.class);

    private KafkaTemplate<String, User> kafkaTemplate;

    public JSONProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendJson(User data){
        LOGGER.info(String.format("JSON Message is %s",data.toString()));
        Message<User> message = MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC,"JsonTopic").build();
        kafkaTemplate.send(message);
    }
}
