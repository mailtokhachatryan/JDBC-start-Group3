package service.user.impl;

import exception.UserAlreadyExistsException;
import exception.ValidationException;
import model.User;
import repository.user.UserRepository;
import service.user.AuthService;

import java.sql.Connection;
import java.sql.SQLException;

public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final Connection connection;

    public AuthServiceImpl(UserRepository userRepository, Connection connection) {
        this.userRepository = userRepository;
        this.connection = connection;
    }

    @Override
    public void login(String email, String password) {
        validate(email, password);
        User user = userRepository.getByEmail(email);
        if (user != null && password.equals(user.getPassword()))
            System.out.println("login successfully completed");
        else
            throw new ValidationException("Email or Password not valid");
    }

    @Override
    public void register(User user)  {
        validate(user.getEmail(), user.getPassword());
        User byEmail = userRepository.getByEmail(user.getEmail());
        if (byEmail != null)
            throw new UserAlreadyExistsException();
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
