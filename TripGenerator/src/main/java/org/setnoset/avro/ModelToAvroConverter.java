package org.setnoset.avro;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ModelToAvroConverter {
    public Delivery convert(org.setnoset.model.Delivery deliveryModel) {
        Map<CharSequence, Integer> items = deliveryModel.getItems().entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return new Delivery(deliveryModel.getStore(), items);
    }

    public Trip convert(org.setnoset.model.Trip tripModel) {
        List<Delivery> deliveries = tripModel.getDeliveries().stream()
                .map(this::convert).toList();

        return new Trip(tripModel.getStartTime().toString(), deliveries);
    }
}
