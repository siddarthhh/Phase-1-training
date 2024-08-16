package com.rms.impl;

import com.rms.intf.UserIntf;
import com.rms.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of UserIntf for managing users.
 */
public class UserImpl implements UserIntf {
    private List<User> users = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public void createUser(User user) {
        user.setId(idCounter++);
        users.add(user);
    }

    @Override
    public User readUser(int id) {
        return users.stream()
                    .filter(user -> user.getId() == id)
                    .findFirst()
                    .orElse(null);
    }

    @Override
    public void updateUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == user.getId()) {
                users.set(i, user);
                return;
            }
        }
    }

    @Override
    public void deleteUser(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
}
