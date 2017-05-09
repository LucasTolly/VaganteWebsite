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

import edu.matc.utils.VerifyRecaptcha;

/**
 * This servlet will acts as both the login page and as a gatekeeper
 * for incorrect Google reCaptcha
 */
@WebServlet(
        urlPatterns = {"/login"}
)
public class Login extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Overriden doGet that simply redirects to login.jsp
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * Overriden doPost that checks if a Google Recaptcha
     * was correctly filled out; otherwise it will not
     * insert the user that was requested to be created.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gRecaptchaResponse =
                req.getParameter("g-recaptcha-response");

        boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);

        if (verify) {
            req.setAttribute("captchaResult", "Success! Account has been created.");
            if (req.getParameter("username") != null && req.getParameter("password") != null) {
                String username = (String) req.getParameter("username");
                String password = (String) req.getParameter("password");
                User newUser = new User(username, password);

                UserRoles userRole = new UserRoles(username, "user");

                UserDao userDao = new UserDao();
                userDao.addUser(newUser);
                UserRolesDao userRolesDao = new UserRolesDao();
                userRolesDao.addUserRoles(userRole);
            }
        } else {
            req.setAttribute("captchaResult", "Failure!");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
        dispatcher.forward(req, resp);
    }
}