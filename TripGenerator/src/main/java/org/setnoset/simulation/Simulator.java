package org.setnoset.simulation;

import org.setnoset.avro.ModelToAvroConverter;
import org.setnoset.messaging.TripProducer;
import org.setnoset.model.Delivery;
import org.setnoset.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@Component
public class Simulator {
    TripProducer tripProducer;

    @Autowired
    public Simulator(TripProducer tripProducer) {
        this.tripProducer = tripProducer;
    }

    @EventListener(ApplicationStartedEvent.class)
    public void simulateTripGeneration() throws InterruptedException {
        Delivery delivery1 = new Delivery(
                "A",
                Map.of(
                        "Apple", 100,
                        "Banana", 70,
                        "Grape", 50
                )
        );

        Trip trip1 = new Trip(List.of(delivery1), ZonedDateTime.now().plusSeconds(10));

        Delivery delivery2 = new Delivery(
                "A",
                Map.of(
                        "Apple", 80,
                        "Banana", 100,
                        "Grape", 130
                )
        );

        Delivery delivery3 = new Delivery(
                "B",
                Map.of(
                        "Apple", 110,
                        "Banana", 120,
                        "Grape", 70
                )
        );

        Trip trip2 = new Trip(List.of(delivery2, delivery3), ZonedDateTime.now().plusSeconds(7));

        tripProducer.send(trip1);
        Thread.sleep(1000);
        tripProducer.send(trip2);
    }
}
