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
import java.util.ArrayList;
import java.util.List;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/areas"}
)

public class Areas extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        AreaDao areaDao = new AreaDao();

        List<Area> allMonsters = areaDao.getAllAreas();
        List<AreaDisplay> allMonsterDisplays = new ArrayList<AreaDisplay>();

        for (Area area : allMonsters) {
            allMonsterDisplays.add(new AreaDisplay(area));
        }

        req.setAttribute("areas", allMonsterDisplays);

        RequestDispatcher dispatcher = req.getRequestDispatcher("areas.jsp");
        dispatcher.forward(req, resp);
    }
}