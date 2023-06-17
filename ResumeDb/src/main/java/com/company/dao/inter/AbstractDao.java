package com.company.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDao {

    public Connection connect() throws Exception {
        String url = "jdbc:mysql://localhost:3306/resumeDb";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
}
