package service.user;

import model.User;

import java.sql.SQLException;

public interface AuthService {

    void login(String email, String password);

    void update(User user);

    void register(User user);

    void transfer(int fromUserId, int toUserId, int amount) throws SQLException;
}
