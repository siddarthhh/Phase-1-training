package com.rms.repository;

import com.rms.models.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuItemRepository {
    private Map<Integer, MenuItem> menuItemMap = new HashMap<>();
    private static int idCounter = 1;

    public void add(MenuItem menuItem) {
        menuItem.setId(idCounter++);
        menuItemMap.put(menuItem.getId(), menuItem);
    }

    public MenuItem get(int id) {
        return menuItemMap.get(id);
    }

    public void update(MenuItem menuItem) {
        menuItemMap.put(menuItem.getId(), menuItem);
    }

    public void remove(int id) {
        menuItemMap.remove(id);
    }

    public List<MenuItem> getAll() {
        return new ArrayList<>(menuItemMap.values());
    }
}
