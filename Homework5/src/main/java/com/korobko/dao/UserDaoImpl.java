package com.korobko.dao;

import com.korobko.model.User;

import java.sql.Connection;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

}
