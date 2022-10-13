package org.setnoset.model;

import java.util.HashMap;
import java.util.Map;

public final class Delivery {
    private final String store;
    private final Map<String, Integer> items;

    public Delivery(String store, Map<String, Integer> items) {
        this.store = store;
        this.items = new HashMap<>(items);
    }

    public String getStore() {
        return store;
    }

    public Map<String, Integer> getItems() {
        return items;
    }
}
