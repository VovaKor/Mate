package com.korobko.controller;


import com.korobko.model.User;
import com.korobko.service.UserService;

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User create(User user) {
        return userService.create(user);
    }
}
