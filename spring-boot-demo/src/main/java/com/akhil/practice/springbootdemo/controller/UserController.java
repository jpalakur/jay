package com.akhil.practice.springbootdemo.controller;

import com.akhil.practice.springbootdemo.model.User;
import com.akhil.practice.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/v1/user/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.findUser(id);
    }

    @PostMapping("/v1/user/save")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/v1/user/all")
    public List<User> getUserById() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/v1/user/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.deleteUserAction(id);
        return "User is deleted";
    }
}
