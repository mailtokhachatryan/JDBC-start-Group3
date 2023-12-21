package service;

import model.User;

import java.sql.SQLException;

public interface UserService {
    void register(User user);

    void transfer(int fromUserId, int toUserId, int amount) throws SQLException;
}
