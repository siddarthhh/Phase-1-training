package com.rms.impl;

import com.rms.intf.MenuItemIntf;
import com.rms.models.MenuItem;
import com.rms.repository.MenuItemRepository;

import java.util.List;

public class MenuItemImpl implements MenuItemIntf {
    private MenuItemRepository repository = new MenuItemRepository();
    
    @Override
    public void createMenuItem(MenuItem menuItem) {
        repository.add(menuItem);
    }

    @Override
    public MenuItem readMenuItem(int id) {
        return repository.get(id);
    }

    @Override
    public void updateMenuItem(MenuItem menuItem) {
        repository.update(menuItem);
    }

    @Override
    public void deleteMenuItem(int id) {
        repository.remove(id);
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        return repository.getAll();
    }
}
