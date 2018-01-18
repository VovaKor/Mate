package com.korobko.services;

import com.korobko.dao.UserDao;
import com.korobko.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Vova Korobko
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserDao userDao;

    @Override
    public User addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRegisterDate(LocalDateTime.now());
        return userDao.addUser(user);
    }
}
