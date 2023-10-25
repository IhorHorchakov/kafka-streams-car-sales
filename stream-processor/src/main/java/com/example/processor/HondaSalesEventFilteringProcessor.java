package com.example.processor;

import com.example.event.CarSaleEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.stereotype.Component;

import static com.example.config.KafkaTopicConfig.HONDA_SALES_TOPIC;

/**
 * The HondaSaleEventFilteringProcessor reads the data from the source car-sales-topic and filters out car sales
 * and pushes only Honda sales into a new topic called honda-sales-topic.
 **/
@Component
@Slf4j
public class HondaSalesEventFilteringProcessor {
    private final static String HONDA_CAR_MAKE = "HONDA";

    public void process(KStream<String, CarSaleEvent> stream) {
        stream.filter((key, event) -> HONDA_CAR_MAKE.equals(event.getMake())).to(HONDA_SALES_TOPIC);
    }
}
