package com.rms.intf;

import com.rms.models.User;

import java.util.List;

/**
 * Interface for User operations.
 */
public interface UserIntf {
    void createUser(User user);
    User readUser(int id);
    void updateUser(User user);
    void deleteUser(int id);
    List<User> getAllUsers();
}
