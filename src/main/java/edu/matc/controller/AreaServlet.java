package edu.matc.controller;

import edu.matc.entity.Area;
import edu.matc.entity.AreaDisplay;
import edu.matc.persistence.AreaDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This servlet gets a specific Area via URL parameters
 * @author tolly
 */
@WebServlet(
        urlPatterns = {"/area"}
)
public class AreaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        AreaDao areaDao = new AreaDao();
        int areaId = Integer.valueOf(req.getParameter("id"));

        Area area = areaDao.getArea(areaId);

        AreaDisplay areaDisplay = new AreaDisplay(area);

        req.setAttribute("area", areaDisplay);

        RequestDispatcher dispatcher = req.getRequestDispatcher("area.jsp");
        dispatcher.forward(req, resp);
    }
}