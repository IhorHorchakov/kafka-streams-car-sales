package com.example.processor;

import com.example.event.CarSaleEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.stereotype.Component;

import static com.example.config.KafkaTopicConfig.HONDA_SALE_TOPIC;

/**
 * KStream is an abstraction of a record stream of KeyValue pairs, i.e., each record is an independent entity/event in the real world.
 * A KStream is either defined from one or multiple Kafka topics that are consumed message by message or the result of a KStream transformation.
 * <p>
 * The HondaSaleEventFilteringProcessor reads the data from the source car-sales-topic and filters out car sales
 * and pushes only Honda sales into a new topic called honda-sales-topic.
 **/
@Component
@Slf4j
public class HondaSalesEventFilteringProcessor {
    private final static String HONDA_CAR_MAKE = "HONDA";

    public void process(KStream<String, CarSaleEvent> stream) {
        stream.filter((key, event) -> {
            if (HONDA_CAR_MAKE.equals(event.getMake())) {
                log.info("Sending CarSaleEvent {} into the topic {}", event, HONDA_SALE_TOPIC);
                return true;
            } else {
                return false;
            }
        }).to(HONDA_SALE_TOPIC);
    }
}
