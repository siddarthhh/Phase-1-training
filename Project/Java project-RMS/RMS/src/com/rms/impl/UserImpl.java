package com.rms.impl;

import com.rms.intf.UserIntf;
import com.rms.models.User;
import com.rms.repository.UserRepository;

import java.util.List;

public class UserImpl implements UserIntf {
    private UserRepository repository = new UserRepository();
    
    @Override
    public void createUser(User user) {
        repository.add(user);
    }

    @Override
    public User readUser(int id) {
        return repository.get(id);
    }

    @Override
    public void updateUser(User user) {
        repository.update(user);
    }

    @Override
    public void deleteUser(int id) {
        repository.remove(id);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.getAll();
    }
}
