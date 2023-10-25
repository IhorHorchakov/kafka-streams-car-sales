package com.example.event.serge;

import com.example.event.DealershipSalesEvent;
import org.apache.kafka.common.serialization.Serdes;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

/**
 * A custom serializer/deserializer for the DealershipSalesEvent.
 */
public class DealershipSalesEventSerge extends Serdes.WrapperSerde<DealershipSalesEvent> {

    public DealershipSalesEventSerge() {
        super(new JsonSerializer<>(), new JsonDeserializer<>(DealershipSalesEvent.class));
    }
}

