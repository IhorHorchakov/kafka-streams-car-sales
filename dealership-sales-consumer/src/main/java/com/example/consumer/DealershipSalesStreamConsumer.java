package com.example.consumer;

import com.example.event.DealershipSalesEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KGroupedStream;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.state.KeyValueBytesStoreSupplier;
import org.apache.kafka.streams.state.Stores;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DealershipSalesStreamConsumer {
    public void consume(KStream<String, DealershipSalesEvent> stream) {
        log.info("Consume stream");
        // Group sales by dealer
        KGroupedStream<String, Integer> salesByDealerName =
                stream.map((key, event) -> new KeyValue<>(event.getName(), event.getPrice())).groupByKey();

        // Aggregate price to summarize total amount of sales by dealer
        KTable<String, AggregateTotal> dealerAggregate = salesByDealerName.aggregate(() -> new AggregateTotal(),
                (key, price, aggregate) -> {
                    aggregate.setTotalPrice(aggregate.getTotalPrice() + price);
                    return aggregate;
                });

        // Create in-memory store
        KeyValueBytesStoreSupplier store = Stores.inMemoryKeyValueStore("dealer-sales-store");

        // Map aggregated KTable to <dealer name, total price> entry and put it to the store
        dealerAggregate.mapValues(AggregateTotal::getTotalPrice, Materialized.as(store));

        log.info("dealer-sales-store: {}", store);
    }
}
