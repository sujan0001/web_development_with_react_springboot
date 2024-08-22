package com.example.sujanproject.Controller;

import com.example.sujanproject.Entity.User;
import com.example.sujanproject.Pojo.UserPojo;
import com.example.sujanproject.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public void saveData(@RequestBody UserPojo userPojo) {
        this.userService.saveData(userPojo);

    }
    @GetMapping("/get")
    public List<User> findAll(){
        return this.userService.findAll();
    }



    @PostMapping("/login")
    public boolean login(@RequestBody User request){
        String email=request.getEmail();
        String password=request.getPassword();
        return userService.login(email, password);

    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserPojo userPojo) {
        return userService.updateUser(id, userPojo);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }


//@RestController
//@RequestMapping("/users")
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/getAll")
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }
//
//    @GetMapping("get/{id}")
//    public User getUserById(@PathVariable Long id) {
//        return userService.getUserById(id);
//    }
//
//    @PostMapping("/save")
//    public User saveUser(@RequestBody User user) {
//        return userService.saveUser(user);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteUser(@PathVariable Long id) {
//        userService.deleteUser(id);
//    }








}
