package edu.matc.controller;

import edu.matc.entity.Monster;
import edu.matc.entity.MonsterDisplay;
import edu.matc.persistence.MonsterDao;

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
 * This servlet gets a Monster via an ID from the URL parameters.
 * @author tolly
 */
@WebServlet(
        urlPatterns = {"/monster"}
)
public class MonsterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MonsterDao monsterDao = new MonsterDao();
        int monsterId = Integer.valueOf(req.getParameter("id"));

        Monster monster = monsterDao.getMonster(monsterId);

        MonsterDisplay monsterDisplay = new MonsterDisplay(monster);

        req.setAttribute("monster", monsterDisplay);

        RequestDispatcher dispatcher = req.getRequestDispatcher("monster.jsp");
        dispatcher.forward(req, resp);
    }
}