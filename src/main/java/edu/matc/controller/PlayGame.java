package edu.matc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.ActiveGame;
import edu.matc.entity.User;
import edu.matc.persistence.DeckOfCardsDAO;
import edu.matc.deckOfCards.Deck;
import edu.matc.persistence.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/playGame"}
)
public class PlayGame extends HttpServlet {
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

        DeckOfCardsDAO ddao = new DeckOfCardsDAO();

        Deck deck = ddao.getDeck();
        request.setAttribute("Deck", deck);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/gameScreen.jsp");
        dispatcher.forward(request, response);
    }
}
