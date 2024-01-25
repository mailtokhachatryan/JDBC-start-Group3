package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private static Connection connection;

    public DataSource(String url, String username, String password, String driver) {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connected to the PostgreSQL server successfully.");
    }

    public Connection getConnection() {
        return connection;
    }
}
