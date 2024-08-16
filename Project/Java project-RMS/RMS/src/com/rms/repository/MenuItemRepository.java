package com.rms.repository;

import com.rms.models.MenuItem;

import java.util.ArrayList;
import java.util.List;


/**
 * Repository for storing and managing MenuItem entities.
 */
public class MenuItemRepository {
    private List<MenuItem> menuItems = new ArrayList<>();
    private int idCounter = 1;

    public void save(MenuItem menuItem) {
        menuItem.setId(idCounter++);
        menuItems.add(menuItem);
    }

    public MenuItem findById(int id) {
        return menuItems.stream()
                        .filter(item -> item.getId() == id)
                        .findFirst()
                        .orElse(null);
    }

    public void update(MenuItem menuItem) {
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getId() == menuItem.getId()) {
                menuItems.set(i, menuItem);
                return;
            }
        }
    }

    public void delete(int id) {
        menuItems.removeIf(item -> item.getId() == id);
    }

    public List<MenuItem> findAll() {
        return new ArrayList<>(menuItems);
    }
}
