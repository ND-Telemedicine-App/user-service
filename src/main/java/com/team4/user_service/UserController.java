package com.team4.user_service;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping(value = "/user/doctors")
    public List<User> getAllDoctors(){
        return userService.findAllDoctors();
    }

    @PostMapping(value = "/createUser")
    public User createUser(@RequestBody User newUser){
        return userService.saveUser(newUser);
    }
}