package com.gnanendraprasadp.kafkaproject.kafka.topic;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class PremiumTopic {

    @Bean
    public NewTopic newTopic(){
        return TopicBuilder.name("PremiumUsers").partitions(10).replicas(1).build();
    }
}
