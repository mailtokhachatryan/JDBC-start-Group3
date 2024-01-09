package controller;

import exception.UserAlreadyExistsException;
import model.User;
import repository.user.UserRepository;
import repository.user.impl.UserRepositoryJDBCImpl;
import service.user.AuthService;
import service.user.impl.AuthServiceImpl;
import util.DataSource;
import util.constants.Parameter;
import util.constants.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class RegisterServlet extends HttpServlet {

    Connection connection = DataSource.getConnection();
    UserRepository userRepository = new UserRepositoryJDBCImpl(connection);
    AuthService authService = new AuthServiceImpl(userRepository, connection);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter(Parameter.NAME);
        String lastname = req.getParameter(Parameter.LAST_NAME);
        String age = req.getParameter(Parameter.AGE);
        String email = req.getParameter(Parameter.EMAIL);
        String password = req.getParameter(Parameter.PASSWORD);
        User user = new User(name, lastname, email, password, Integer.parseInt(age));
        try {
            authService.register(user);
<<<<<<< Updated upstream
            resp.sendRedirect("index.jsp");
=======
            resp.sendRedirect(Path.WELCOME);
>>>>>>> Stashed changes
        } catch (UserAlreadyExistsException e){
            resp.sendRedirect(Path.REGISTER);
        }


    }

}
