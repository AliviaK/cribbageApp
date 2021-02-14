package edu.matc.controller;

import edu.matc.persistence.PropertiesLoader;
import edu.matc.persistence.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class AddUser extends HttpServlet {
    final Logger logger = LogManager.getLogger(PropertiesLoader.class);

    /**
     *  Handles HTTP requests.
     *
     * @param  request                   the HttpServletRequest object
     * @param  response                   the HttpServletResponse object
     * @exception IOException       if there is an IO failure
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDao userDao = new UserDao();
        String username = request.getParameter("username");

        if (username != null) {
            request.setAttribute("users", userDao.getByPropertyLike("userName", username));
        } else {
            request.setAttribute("users", userDao.getAll());
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/results.jsp");
        dispatcher.forward(request, response);

    }
}