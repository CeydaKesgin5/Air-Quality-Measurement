package com.example.intern2.controller;


import com.example.intern2.entity.User;
import com.example.intern2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;

    @Autowired
    public  UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public User getUser(Integer id){

        return userService.getById(id);
    }

    @PostMapping()
    public User saveUser(@RequestBody User user) {
        User savedUser = userService.save(user);

        return savedUser;
    }

    @PostMapping("/login")

    public ResponseEntity<String> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

        try {
            String username_ = userService.findByUsername(username);
            String password_ = userService.findByPassword(username);

            if (username_.equals(username) && password_.equals(password)) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
            }
        } catch (Exception e) {
            e.printStackTrace(); //hata detaylarını konsola yazar
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during login");
        }

    }



}
