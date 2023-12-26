package controller;

import exception.ValidationException;
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

public class LoginServlet extends HttpServlet {


    Connection connection = DataSource.getConnection();
    UserRepository userRepository = new UserRepositoryJDBCImpl(connection);
    UserService userService = new UserServiceImpl(userRepository, connection);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try {
            userService.login(email,password);
            resp.sendRedirect("home.html");
        }
        catch (ValidationException e){
            resp.sendRedirect("index.html");
        }




    }
}
