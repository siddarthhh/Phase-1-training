package com.rms.intf;

import com.rms.models.RestaurantTable;

import java.util.List;

public interface RestaurantTableIntf {
    void createRestaurantTable(RestaurantTable table);
    RestaurantTable readRestaurantTable(int id);
    void updateRestaurantTable(RestaurantTable table);
    void deleteRestaurantTable(int id);
    List<RestaurantTable> getAllRestaurantTables();
}
