package com.korobko.service;

import com.korobko.dao.UserDao;
import com.korobko.model.User;
import com.korobko.util.BaseUtil;

import java.time.LocalTime;
import java.util.Optional;


public class UserServiceImpl implements UserService {

    private UserDao userDao;


    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public User create(User user) {
        return userDao.create(user);
    }

    @Override
    public Optional<String> checkUser(String email, String password) {
        User user = userDao.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            String token = BaseUtil.getUserToken();
            user.setToken(token);
            userDao.update(user);
            return Optional.of(token);
        }
        return Optional.empty();
    }
}
