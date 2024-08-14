package com.rms.repository;

import com.rms.models.RestaurantTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantTableRepository {
    private Map<Integer, RestaurantTable> tableMap = new HashMap<>();
    private static int idCounter = 1;

    public void add(RestaurantTable table) {
        table.setId(idCounter++);
        tableMap.put(table.getId(), table);
    }

    public RestaurantTable get(int id) {
        return tableMap.get(id);
    }

    public void update(RestaurantTable table) {
        tableMap.put(table.getId(), table);
    }

    public void remove(int id) {
        tableMap.remove(id);
    }

    public List<RestaurantTable> getAll() {
        return new ArrayList<>(tableMap.values());
    }
}
