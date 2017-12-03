package com.korobko;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory {

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:h2:tcp://localhost/~/test",
                    "sa",
                    "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
