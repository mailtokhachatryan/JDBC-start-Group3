package controller;

import model.User;
import repository.UserRepository;
import repository.impl.UserRepositoryJDBCImpl;
import service.UserService;
import service.impl.UserServiceImpl;
import util.DataSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class RegisterServlet extends HttpServlet {

    Connection connection = DataSource.getConnection();
    UserRepository userRepository = new UserRepositoryJDBCImpl(connection);
    UserService userService = new UserServiceImpl(userRepository, connection);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        String age = req.getParameter("age");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User(name, lastname, email, password, Integer.parseInt(age));
        userService.register(user);

        resp.sendRedirect("index.html");
    }

}
