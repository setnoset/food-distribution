package org.setnoset.messaging;

import org.setnoset.avro.ModelToAvroConverter;
import org.setnoset.avro.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class TripProducer {
    private final KafkaTemplate<String, Trip> template;

    @Autowired
    public TripProducer(KafkaTemplate<String, Trip> template) {
        this.template = template;
    }

    public void send(Trip trip) {
        template.send("Trip", trip);
    }

    public void send(org.setnoset.model.Trip trip) {
        send(new ModelToAvroConverter().convert(trip));
    }
}
