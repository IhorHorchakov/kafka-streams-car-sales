package com.example.processor;

import com.example.config.KafkaStreamsConfig;
import com.example.event.CarSaleEvent;
import com.example.event.DealershipSalesEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.stereotype.Component;

import static com.example.config.KafkaTopicConfig.DEALERSHIP_SALES_TOPIC;

/**
 * The DealershipSalesEventMappingProcessor reads the data from the source car-sales-topic
 * and maps it to the DealershipSalesEvent, and pushes this event to the new topic dealer-sales-topic.
 **/
@Component
@Slf4j
public class DealershipSalesEventMappingProcessor {

    public void process(KStream<String, CarSaleEvent> stream) {
        stream.mapValues(event -> new DealershipSalesEvent(event.getDealerId(), event.getDealerName(), event.getPrice()))
              .to(DEALERSHIP_SALES_TOPIC);
    }
}
