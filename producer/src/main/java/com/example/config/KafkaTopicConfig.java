package com.example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    public final static String TOPIC = "car-sales-topic";

    @Bean
    public NewTopic carSalesTopic() {
        return TopicBuilder
                .name(TOPIC)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
