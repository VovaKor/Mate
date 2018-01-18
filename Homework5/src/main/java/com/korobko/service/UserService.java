package com.korobko.service;

import com.korobko.model.User;

import java.util.Optional;

public interface UserService {

    User create(User user);

    Optional<String> checkUser(String email, String password);

    User findById(long id);
}
