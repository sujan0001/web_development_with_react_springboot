package com.example.sujanproject.Service;

import com.example.sujanproject.Entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
//    User getUserByUsername(String username);
}
