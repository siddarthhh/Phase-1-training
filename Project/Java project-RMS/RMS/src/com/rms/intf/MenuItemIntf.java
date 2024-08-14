package com.rms.intf;

import com.rms.models.MenuItem;

import java.util.List;

public interface MenuItemIntf {
    void createMenuItem(MenuItem menuItem);
    MenuItem readMenuItem(int id);
    void updateMenuItem(MenuItem menuItem);
    void deleteMenuItem(int id);
    List<MenuItem> getAllMenuItems();
}
