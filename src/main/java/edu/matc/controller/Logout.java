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

/**
 * This servlet's log is to log the user out.
 */
@WebServlet(
        urlPatterns = {"/logout"}
)
public class Logout extends HttpServlet {
    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Overriden doGet that logs the user out.
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.logout();;

        RequestDispatcher dispatcher = req.getRequestDispatcher("logout.jsp");
        dispatcher.forward(req, resp);
    }
}