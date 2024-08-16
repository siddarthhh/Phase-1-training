package com.rms.impl;

import com.rms.intf.RestaurantTableIntf;
import com.rms.models.RestaurantTable;

import java.util.ArrayList;
import java.util.List;


/**
 * Implementation of RestaurantTableIntf for managing restaurant tables.
 */
public class RestaurantTableImpl implements RestaurantTableIntf {
    private List<RestaurantTable> restaurantTables = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public void createRestaurantTable(RestaurantTable restaurantTable) {
        restaurantTable.setId(idCounter++);
        restaurantTables.add(restaurantTable);
    }

    @Override
    public RestaurantTable readRestaurantTable(int id) {
        return restaurantTables.stream()
                               .filter(table -> table.getId() == id)
                               .findFirst()
                               .orElse(null);
    }

    @Override
    public void updateRestaurantTable(RestaurantTable restaurantTable) {
        for (int i = 0; i < restaurantTables.size(); i++) {
            if (restaurantTables.get(i).getId() == restaurantTable.getId()) {
                restaurantTables.set(i, restaurantTable);
                return;
            }
        }
    }

    @Override
    public void deleteRestaurantTable(int id) {
        restaurantTables.removeIf(table -> table.getId() == id);
    }

    @Override
    public List<RestaurantTable> getAllRestaurantTables() {
        return new ArrayList<>(restaurantTables);
    }
}
