package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private static final String URL = "jdbc:postgresql://localhost:5432/jdbc";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "postgres";
    private static Connection connection;


    private DataSource() {

    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Connected to the PostgreSQL server successfully.");
        }

        return connection;
    }


}
