package com.example.service;

import com.example.model.CarMake;
import com.example.model.CarModel;
import com.example.event.CarSaleEvent;
import com.example.model.Dealership;
import com.example.util.RandomGenerator;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static com.example.util.RandomGenerator.*;

@Component
public class EventGenerator {
    private final static Integer MIN_PRICE = 20000;
    private final static Integer MAX_PRICE = 60000;

    public CarSaleEvent generateRandomCarSaleEvent() {
        Dealership dealership = RandomGenerator.randomEnum(Dealership.class);
        CarMake carMake = randomListItem(dealership.getCarMakeList());
        CarModel carModel = randomListItem(carMake.getModels());
        return CarSaleEvent.builder()
                .make(carMake)
                .model(carModel)
                .dealerId(dealership.getId())
                .dealerName(dealership.getCaption())
                .transactionId(UUID.randomUUID().toString())
                .price(randomIntegerInRange(MIN_PRICE, MAX_PRICE))
                .timestamp(randomDate().format(DateTimeFormatter.ISO_DATE))
                .build();
    }
}
