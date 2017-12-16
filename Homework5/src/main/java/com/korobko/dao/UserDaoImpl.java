package com.korobko.dao;

import com.korobko.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Homework #4
 * Написать в UserDao реализацию метода
 * List<User> getUsersByOrderCreateDate(LocalDate date)
 * Вывести в консоль:
 * User name:       Order details:
 * возвразать не меньше трех пользователей
 * у каждого юзера должно быть не меньше трех заказов
 *
 * @author Vova Korobko
 */
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    List<User> getUsersByOrderCreateDate(LocalDate date) {
        List<User> users = new ArrayList<>();
        return users;
    }


    @Override
    public User getUserByToken(String token) {
        User user = new User();
        try {
            String sql = "SELECT * FROM USERS WHERE TOKEN=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, token);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByEmail(String email) {
        User user = new User();
        try {
            String sql = "SELECT * FROM USERS WHERE EMAIL=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, email);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
