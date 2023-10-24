package com.example.producer;


import com.example.event.CarSaleEvent;
import com.example.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.config.KafkaTopicConfig.TOPIC;

@Component
@Slf4j
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void publish(CarSaleEvent event) {
        log.info("Sending CarSaleEvent='{}' to topic='{}'", event, TOPIC);
        String payload = JsonUtil.objectToJson(event);
        kafkaTemplate.send(TOPIC, payload);
    }
}
