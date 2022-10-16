package org.setnoset.messaging;

import org.setnoset.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class TripProducer {
    private final KafkaTemplate<String, Trip> template;

    @Autowired
    public TripProducer(KafkaTemplate<String, Trip> template) {
        this.template = template;
    }

    public void send(Trip trip) {
        template.send("Trip", trip);
    }
}
