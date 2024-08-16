package com.rms.repository;

import com.rms.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Repository for storing and managing User entities.
 */

public class UserRepository {
    private Map<Integer, User> userMap = new HashMap<>();
    private static int idCounter = 1;

    public void add(User user) {
        user.setId(idCounter++);
        userMap.put(user.getId(), user);
    }

    public User get(int id) {
        return userMap.get(id);
    }

    public void update(User user) {
        userMap.put(user.getId(), user);
    }

    public void remove(int id) {
        userMap.remove(id);
    }

    public List<User> getAll() {
        return new ArrayList<>(userMap.values());
    }
}
