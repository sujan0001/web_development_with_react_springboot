package com.example.sujanproject.Controller;

import com.example.sujanproject.Pojo.UserPojo;
import com.example.sujanproject.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/login")
@RequiredArgsConstructor

public class LoginController {
    private final UserService userService;
    @CrossOrigin(origins = "http://localhost:5173")

    @PostMapping("/authentication")
    public ResponseEntity<Map<String, Object>> authenticateUser(@RequestBody UserPojo loginRequest) {
        Map<String, Object> response = new HashMap<>();

        // For admin login
        String adminUsername = "admin@gmail.com";
        String adminPassword = "passwordadmin";

        if (loginRequest.getEmail().equals(adminUsername) && loginRequest.getPassword().equals(adminPassword)) {
            response.put("message", "Welcome Admin");
            return ResponseEntity.ok(response);
        }

        UserPojo user = userService.findUserByEmail(loginRequest.getEmail());
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            response.put("userId", user.getId()); // Include userId in response
            response.put("message", "Login successful!");
            return ResponseEntity.ok(response);
        }

        // If authentication fails
        response.put("message", "Invalid username or password");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
}