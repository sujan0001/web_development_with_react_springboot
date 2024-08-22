package com.example.sujanproject.Service.Impl;


import com.example.sujanproject.Entity.User;
import com.example.sujanproject.Pojo.UserPojo;
import com.example.sujanproject.Repo.UserRepo;


import com.example.sujanproject.Service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }



    @Override
    public void saveData(UserPojo userPojo) {

        User user = new User();
        user.setUsername(userPojo.getUsername());
        user.setEmail(userPojo.getEmail());
        user.setPassword(userPojo.getPassword());
        user.setAddress(userPojo.getAddress());
        user.setPhone(userPojo.getPhone());

        userRepo.save(user);

    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findbyEmail(String email) {
        return userRepo.findByEmail(email);
    }



    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

    }

    @Override
    public void deleteById(Long id) {

        User user = userRepo.findById(id).orElse(null);
        if (user != null) {
            userRepo.delete(user);
        }

    }

    @Override
    public UserPojo findUserByEmail(String email) {
        User entity = userRepo.findByEmail(email);
        if (entity != null) {
            UserPojo pojo = new UserPojo();
            BeanUtils.copyProperties(entity, pojo);
            return pojo;
        }
        return null;
    }

    @Override
    public User updateUser(Long id, UserPojo userPojo) {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userPojo.getUsername());
        user.setEmail(userPojo.getEmail());
        user.setPassword(userPojo.getPassword());
        user.setPhone(userPojo.getPhone());
        user.setAddress(userPojo.getAddress());
        return userRepo.save(user);
    }

//    @Autowired
//    private UserRepo userRepo;
//
//    @Override
//    public List<User> getAllUsers() {
//        return userRepo.findAll();
//    }
//
//    @Override
//    public User getUserById(Long id) {
//        return userRepo.findById(id).orElse(null);
//    }
//
//    @Override
//    public User saveUser(User user) {
//        return userRepo.save(user);
//    }
//
//    @Override
//    public void deleteUser(Long id) {
//        userRepo.deleteById(id);
//    }




//    @Override
//    public User getUserByUsername(String username) {
//        return userRepo.findBy;
//    }
}
