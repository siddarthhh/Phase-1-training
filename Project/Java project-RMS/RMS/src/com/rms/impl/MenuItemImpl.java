package com.rms.impl;

import com.rms.intf.MenuItemIntf;
import com.rms.models.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of MenuItemIntf interface.
 */
public class MenuItemImpl implements MenuItemIntf {
    private Map<Integer, MenuItem> menuItemMap = new HashMap<>();
    private int currentId = 1;

    @Override
    public void createMenuItem(MenuItem item) {
        item.setId(currentId++);
        menuItemMap.put(item.getId(), item);
    }

    @Override
    public MenuItem readMenuItem(int id) {
        return menuItemMap.get(id);
    }

    @Override
    public void updateMenuItem(MenuItem item) {
        if (menuItemMap.containsKey(item.getId())) {
            menuItemMap.put(item.getId(), item);
        }
    }

    @Override
    public void deleteMenuItem(int id) {
        menuItemMap.remove(id);
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        return new ArrayList<>(menuItemMap.values());
    }
}
