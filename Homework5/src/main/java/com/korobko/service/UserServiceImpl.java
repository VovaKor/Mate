package com.korobko.service;

import com.korobko.dao.UserDao;
import com.korobko.model.User;


public class UserServiceImpl implements UserService {

    private UserDao userDao;


    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public User create(User user) {
        return userDao.create(user);
    }
}
