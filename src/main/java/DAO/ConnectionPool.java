package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;


public class ConnectionPool {
    private static BasicDataSource dataSource;

    static {
        // Configure the data source
        dataSource = new BasicDataSource();
        dataSource.setUrl("db.url");
        dataSource.setUsername("db.username");
        dataSource.setPassword("db.password");
        dataSource.setMinIdle(15);
        dataSource.setMaxIdle(50);
        dataSource.setMaxWaitMillis(20000);
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Error getting database connection", e);
        }
    }
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing database connection");
                e.printStackTrace();
            }
        }
    }

    public static void shutdown() {
        try {
            dataSource.close();
        } catch (SQLException e) {
            System.out.println("Error shutting down connection pool");
            e.printStackTrace();
        }
    }
}





