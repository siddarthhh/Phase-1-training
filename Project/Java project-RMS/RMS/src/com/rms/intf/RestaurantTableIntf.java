package com.rms.intf;

import com.rms.models.RestaurantTable;

import java.util.List;

/**
 * Interface for RestaurantTable data access operations.
 */
public interface RestaurantTableIntf {
    void createRestaurantTable(RestaurantTable table);
    RestaurantTable readRestaurantTable(int id);
    void updateRestaurantTable(RestaurantTable table);
    void deleteRestaurantTable(int id);
    List<RestaurantTable> getAllRestaurantTables();
}
