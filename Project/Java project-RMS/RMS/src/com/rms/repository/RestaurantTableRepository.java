package com.rms.repository;

import com.rms.models.RestaurantTable;

import java.util.ArrayList;
import java.util.List;


/**
 * Repository for storing and managing RestaurantTable entities.
 */
public class RestaurantTableRepository {
    private List<RestaurantTable> restaurantTables = new ArrayList<>();
    private int idCounter = 1;

    public void save(RestaurantTable restaurantTable) {
        restaurantTable.setId(idCounter++);
        restaurantTables.add(restaurantTable);
    }

    public RestaurantTable findById(int id) {
        return restaurantTables.stream()
                               .filter(table -> table.getId() == id)
                               .findFirst()
                               .orElse(null);
    }

    public void update(RestaurantTable restaurantTable) {
        for (int i = 0; i < restaurantTables.size(); i++) {
            if (restaurantTables.get(i).getId() == restaurantTable.getId()) {
                restaurantTables.set(i, restaurantTable);
                return;
            }
        }
    }

    public void delete(int id) {
        restaurantTables.removeIf(table -> table.getId() == id);
    }

    public List<RestaurantTable> findAll() {
        return new ArrayList<>(restaurantTables);
    }
}
