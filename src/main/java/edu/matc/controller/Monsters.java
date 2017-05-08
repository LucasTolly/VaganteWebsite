package edu.matc.controller;

import edu.matc.persistence.MonsterDao;
import edu.matc.entity.Monster;
import edu.matc.entity.MonsterDisplay;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        urlPatterns = {"/monsters"}
)

public class Monsters extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            MonsterDao monsterDao = new MonsterDao();

            List<Monster> allMonsters = monsterDao.getAllMonsters();
            List<MonsterDisplay> allMonsterDisplays = new ArrayList<MonsterDisplay>();

            for (Monster monster : allMonsters) {
                allMonsterDisplays.add(new MonsterDisplay(monster));
            }
            req.setAttribute("monsters", allMonsterDisplays);

        } catch (Exception exception) {
            req.setAttribute("errorLog", "There was an error. Please contact the owner of the site.");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("monsters.jsp");
        dispatcher.forward(req, resp);
    }
}