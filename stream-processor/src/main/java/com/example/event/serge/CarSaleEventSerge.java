package com.example.event.serge;

import com.example.event.CarSaleEvent;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

/**
 * A custom serializer/deserializer for the CarSaleEvent object data.
 */
public class CarSaleEventSerge extends Serdes.WrapperSerde<CarSaleEvent> {

    public CarSaleEventSerge() {
        super(new JsonSerializer<>(), new JsonDeserializer<>(CarSaleEvent.class));
    }
}
