package com.example.sujanproject.Service.Impl;


import com.example.sujanproject.Entity.User;
import com.example.sujanproject.Repo.UserRepo;
import com.example.sujanproject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

//    @Override
//    public User getUserByUsername(String username) {
//        return userRepo.findBy;
//    }
}
