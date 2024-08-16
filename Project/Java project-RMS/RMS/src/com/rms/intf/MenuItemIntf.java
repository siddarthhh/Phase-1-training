package com.rms.intf;

import com.rms.models.MenuItem;

import java.util.List;

/**
 * Interface for MenuItem data access operations.
 */
public interface MenuItemIntf {
    void createMenuItem(MenuItem item);
    MenuItem readMenuItem(int id);
    void updateMenuItem(MenuItem item);
    void deleteMenuItem(int id);
    List<MenuItem> getAllMenuItems();
}
