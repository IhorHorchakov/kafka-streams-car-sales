package com.example.service;

import com.example.event.CarSaleEvent;
import com.example.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class EventService {
    private final KafkaProducer kafkaProducer;
    private final EventGenerator eventGenerator;

    @Autowired
    public EventService(KafkaProducer kafkaProducer, EventGenerator eventGenerator) {
        this.kafkaProducer = kafkaProducer;
        this.eventGenerator = eventGenerator;
    }

    /**
     * Publishes random CarSaleEvent to Kafka topic.
     * The method waits first 30 seconds (initialDelay) to let the application context get initialized.
     * Then the method runs at the fixed schedule every 1 second (fixedDelay).
     *
     * !Important:
     * By default, Spring uses a local single-threaded scheduler to run the tasks. As a result, even if we have
     * multiple @Scheduled methods, they each need to wait for the thread to complete executing a previous task.
     * If our tasks are truly independent, it’s more convenient to run them in parallel. For that, we need to
     * provide a TaskScheduler that better suits our needs.
     */
    @Scheduled(initialDelay = 30, fixedDelay = 1, timeUnit = TimeUnit.SECONDS)
    public void publishRandomCarSaleEvent() {
        CarSaleEvent event = eventGenerator.generateRandomCarSaleEvent();
        kafkaProducer.publish(event);
    }
}
