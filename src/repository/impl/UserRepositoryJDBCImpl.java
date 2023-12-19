package repository.impl;

import model.User;
import repository.UserRepository;
import util.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryJDBCImpl implements UserRepository {

    private final Connection connection ;

    public UserRepositoryJDBCImpl(Connection connection) {
        this.connection = connection;
        try (Statement statement = connection.createStatement()) {
            statement.execute("""
                    CREATE TABLE IF NOT EXISTS users(
                        id serial primary key,
                        name varchar not null ,
                        lastname varchar not null ,
                        age integer not null,
                        balance integer default 0
                    );
                    """);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(User user) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(String.format("INSERT INTO users(name, lastname, age) VALUES ('%s','%s',%d)", user.getName(), user.getLastname(), user.getAge()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(
                    String.format("UPDATE users SET name = '%s', lastname = '%s', age = %d, balance = %d WHERE id = %d", user.getName(), user.getLastname(), user.getAge(), user.getBalance(), user.getId())
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (Statement statement = connection.createStatement()) {
            int i = statement.executeUpdate(String.format("DELETE FROM users WHERE id = %d", id));
            System.out.println(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                list.add(prepareUser(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public User getById(int userId) {
        try (Statement statement = connection.createStatement()) {
            User user = null;
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM users WHERE id = %d", userId));
            if (resultSet.next()) {
                user = prepareUser(resultSet);
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private User prepareUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setLastname(resultSet.getString("lastname"));
        user.setAge(resultSet.getInt("age"));
        user.setBalance(resultSet.getInt("balance"));
        return user;
    }

}