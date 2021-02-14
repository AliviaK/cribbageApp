package edu.matc.controller;

import edu.matc.persistence.PropertiesLoader;
import edu.matc.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class SearchUser extends HttpServlet {
    final Logger logger = LogManager.getLogger(PropertiesLoader.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDao userDao = new UserDao();
        String username = req.getParameter("username");

        if (username != null) {
            req.setAttribute("users", userDao.getByPropertyLike("userName", username));
        } else {
            req.setAttribute("users", userDao.getAll());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}