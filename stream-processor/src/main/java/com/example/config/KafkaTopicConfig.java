package com.example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    public final static String HONDA_SALES_TOPIC = "honda-sales-topic";

    @Bean
    public NewTopic hondaSalesTopic() {
        return TopicBuilder
                .name(HONDA_SALES_TOPIC)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
