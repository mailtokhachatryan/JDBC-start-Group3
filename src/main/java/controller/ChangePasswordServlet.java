package controller;

import exception.ValidationException;
import model.User;
import repository.user.UserRepository;
import repository.user.impl.UserRepositoryJDBCImpl;
import service.user.AuthService;
import service.user.impl.AuthServiceImpl;
import util.CookieUtil;
import util.DataSource;
import util.constants.Parameter;
import util.constants.Path;
import util.encoder.AESManager;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class ChangePasswordServlet extends HttpServlet {

    Connection connection = DataSource.getConnection();
    UserRepository userRepository = new UserRepositoryJDBCImpl(connection);
    AuthService authService = new AuthServiceImpl(userRepository, connection);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lastPassword = req.getParameter(Parameter.LAST_PASSWORD);
        String newPassword = req.getParameter(Parameter.NEW_PASSWORD);
        String repeatPassword = req.getParameter(Parameter.REPEAT_PASSWORD);
        try {
        if(!lastPassword.equals(newPassword) && newPassword.equals(repeatPassword)){
            User user=userRepository.getById(Integer.parseInt(req.getSession().getId()));
            user.setPassword(newPassword);
            authService.update(user);
            CookieUtil.updateCookie(req.getCookies(), AESManager.encrypt(user.getEmail()+user.getPassword()));
            resp.sendRedirect(Path.HOME);
        }
        }
        catch (ValidationException e){
            resp.sendRedirect(Path.CHANGE_PASSWORD);
        }

    }

}
