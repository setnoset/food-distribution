package org.setnoset.model;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public final class Trip {
    private final List<Delivery> deliveries;
    private final ZonedDateTime startTime;

    public Trip(List<Delivery> deliveries, ZonedDateTime startTime) {
        this.deliveries = new ArrayList<>(deliveries);
        this.startTime = startTime;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }
}
