package com.example.consumer;

import com.example.config.KafkaConsumerConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.example.config.KafkaConsumerConfig.HONDA_SALES_TOPIC;

@Component
@Slf4j
public class HondaSalesConsumer {

    @KafkaListener(topics = HONDA_SALES_TOPIC, containerFactory = "kafkaListenerContainerFactory")
    public void receive(ConsumerRecord<?, ?> consumerRecord) {
        log.info("Received HondaSaleEvent '{}' from topic '{}'", consumerRecord.value(), HONDA_SALES_TOPIC);
    }
}
