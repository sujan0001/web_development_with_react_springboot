package com.example.sujanproject.Service;

import com.example.sujanproject.Entity.User;
import com.example.sujanproject.Pojo.UserPojo;

import java.util.List;

public interface UserService {
//    List<User> getAllUsers();
//    User getUserById(Long id);
//    User saveUser(User user);
//    void deleteUser(Long id);

    void saveData(UserPojo userPojo);

    List<User>findAll();

    User findbyEmail(String email);

    boolean login(String username, String password);

    User getUserById(Long id);

    void deleteById(Long id);


    UserPojo findUserByEmail(String email);

    User updateUser(Long id, UserPojo userPojo);




//    User getUserByUsername(String username);
}
