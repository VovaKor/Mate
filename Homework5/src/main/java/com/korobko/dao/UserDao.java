package com.korobko.dao;
import com.korobko.model.User;

public interface UserDao extends GenericDao<User> {


    User getUserByToken(String token);
}
