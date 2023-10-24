package com.example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    public final static String TOPIC = "car-sale-topic";

    @Bean
    public NewTopic carSaleTopic() {
        return TopicBuilder
                .name(TOPIC)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
