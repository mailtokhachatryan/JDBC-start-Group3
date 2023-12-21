package service.impl;

import exception.ValidationException;
import model.User;
import repository.UserRepository;
import service.UserService;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Connection connection;

    public UserServiceImpl(UserRepository userRepository, Connection connection) {
        this.userRepository = userRepository;
        this.connection = connection;
    }

    @Override
    public void register(User user) {
        validate(user.getEmail(), user.getPassword());

        userRepository.create(user);
    }

    @Override
    public void transfer(int fromUserId, int toUserId, int amount) throws SQLException {
        connection.setAutoCommit(false);
        try {
            System.out.println("Transfer started");

            User fromUser = userRepository.getById(fromUserId);
            User toUser = userRepository.getById(toUserId);
            fromUser.setBalance(fromUser.getBalance() - amount);
            toUser.setBalance(toUser.getBalance() + amount);
            userRepository.update(fromUser);
            userRepository.update(toUser);
            connection.commit();
            System.out.println("Transfer completed successfully");
        } catch (Throwable e) {
            System.out.println("Transfer canceled");
            connection.rollback();
        }
    }

    private void validate(String email, String password) {
        if (email == null || !email.matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*"
                + "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"))
            throw new ValidationException("Email not valid");

        if (password == null || password.length() < 8)
            throw new ValidationException("Password must be more than 8 symbols");
    }

}