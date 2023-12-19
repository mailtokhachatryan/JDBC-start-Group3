import repository.UserRepository;
import repository.impl.UserRepositoryJDBCImpl;
import service.UserService;
import service.impl.UserServiceImpl;
import util.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = DataSource.getConnection();

        UserRepository userRepository = new UserRepositoryJDBCImpl(connection);
        UserService userService = new UserServiceImpl(userRepository, connection);

        userService.transfer(1, 2, 200);

    }
}