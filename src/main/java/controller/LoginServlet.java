package controller;

import exception.ValidationException;
import repository.user.UserRepository;
import repository.user.impl.UserRepositoryJDBCImpl;
import service.user.AuthService;
import service.user.impl.AuthServiceImpl;
import util.DataSource;
import util.constants.Parameter;
import util.encoder.AESManager;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

public class LoginServlet extends HttpServlet {


    Connection connection = DataSource.getConnection();
    UserRepository userRepository = new UserRepositoryJDBCImpl(connection);
    AuthService authService = new AuthServiceImpl(userRepository, connection);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter(Parameter.EMAIL);
        String password = req.getParameter(Parameter.PASSWORD);
        String rememberMe = req.getParameter(Parameter.REMEMBER_ME); //ON null

        try {
            authService.login(email, password);

            if (rememberMe != null && rememberMe.equalsIgnoreCase("on")) {
                Cookie cookie = new Cookie(Parameter.REMEMBER_COOKIE, AESManager.encrypt(email + ":" + password));
                cookie.setMaxAge(360000);
                resp.addCookie(cookie);
            }
            HttpSession session = req.getSession();
            session.setAttribute("id", userRepository.getByEmail(email).getId());
            session.setAttribute("name", userRepository.getByEmail(email).getName());
            resp.sendRedirect("home.jsp");
        } catch (ValidationException e) {
            resp.sendRedirect("welcome.jsp");
        }

    }
}
