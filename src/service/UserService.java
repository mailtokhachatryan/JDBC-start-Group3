package service;

import java.sql.SQLException;

public interface UserService {
    void transfer(int fromUserId, int toUserId, int amount) throws SQLException;
}
