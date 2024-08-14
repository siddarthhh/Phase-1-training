package com.rms.impl;

import com.rms.intf.RestaurantTableIntf;
import com.rms.models.RestaurantTable;
import com.rms.repository.RestaurantTableRepository;

import java.util.List;

public class RestaurantTableImpl implements RestaurantTableIntf {
    private RestaurantTableRepository repository = new RestaurantTableRepository();
    
    @Override
    public void createRestaurantTable(RestaurantTable table) {
        repository.add(table);
    }

    @Override
    public RestaurantTable readRestaurantTable(int id) {
        return repository.get(id);
    }

    @Override
    public void updateRestaurantTable(RestaurantTable table) {
        repository.update(table);
    }

    @Override
    public void deleteRestaurantTable(int id) {
        repository.remove(id);
    }

    @Override
    public List<RestaurantTable> getAllRestaurantTables() {
        return repository.getAll();
    }
}
