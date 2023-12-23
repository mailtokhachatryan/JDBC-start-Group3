package service;

import model.User;

import java.sql.SQLException;

public interface UserService {

    void login(String email, String password);

    void register(User user);

    void transfer(int fromUserId, int toUserId, int amount) throws SQLException;
}
