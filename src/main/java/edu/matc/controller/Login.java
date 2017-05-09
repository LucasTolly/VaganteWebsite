package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.entity.UserRoles;
import edu.matc.persistence.UserDao;

import edu.matc.persistence.UserRolesDao;
import org.apache.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/login"}
)

public class Login extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Entering doGet for Login");

        RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("username") != null) {
            String username = (String) req.getParameter("username");
            String password = (String) req.getParameter("password");
            User newUser = new User(username, password);

            UserRoles userRole = new UserRoles(username, "user");

            UserDao userDao = new UserDao();
            userDao.addUser(newUser);
            UserRolesDao userRolesDao = new UserRolesDao();
            userRolesDao.addUserRoles(userRole);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
        dispatcher.forward(req, resp);
    }
}