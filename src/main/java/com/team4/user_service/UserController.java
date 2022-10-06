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

    @GetMapping(value = "/user/patients")
    public List<User> getAllPatients(){
        return userService.findAllPatients();
    }

    @GetMapping(value = "/users")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @PostMapping(value = "/createUser")
    public User createUser(@RequestBody User newUser){
        return userService.saveUser(newUser);
    }

    //updates the user's status via searching their user id first
    @PutMapping(value = "/user/update-status/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody String userStatus){
        return userService.updateUserStatus(id, userStatus);
    }
}