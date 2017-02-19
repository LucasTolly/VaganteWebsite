package edu.matc.controller;

import edu.matc.persistence.MonsterDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/monsters"}
)

public class Monsters extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        MonsterDao monsterDao = new MonsterDao();

        req.setAttribute("monsters", monsterDao.getAllMonsters());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/monsters.jsp");
        dispatcher.forward(req, resp);
    }
}