import model.User;
import repository.user.UserRepository;
import repository.user.impl.UserRepositoryJDBCImpl;
import service.user.AuthService;
import service.user.impl.AuthServiceImpl;
import util.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = DataSource.getConnection();

        UserRepository userRepository = new UserRepositoryJDBCImpl(connection);
        AuthService authService = new AuthServiceImpl(userRepository, connection);


        authService.register(
                new User(
                        "Aghasi",
                        "Khachatryan",
                        "mailtokhachatryan@gmail.com",
                        "password",
                        27)
        );
    }
}