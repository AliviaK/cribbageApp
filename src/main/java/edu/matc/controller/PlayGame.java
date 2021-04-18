package edu.matc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.matc.deckOfCards.DrawnCards;
import edu.matc.entity.ActiveGame;
import edu.matc.entity.Player;
import edu.matc.persistence.DeckOfCardsDAO;
import edu.matc.deckOfCards.Deck;
import edu.matc.persistence.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/playGame"}
)
public class PlayGame extends HttpServlet {
    final Logger logger = LogManager.getLogger(PropertiesLoader.class);

    private ActiveGame currentGame;
    private DrawnCards drawn;

    public void startNewGame() throws JsonProcessingException {
        currentGame = new ActiveGame();
        currentGame.startNewGame();
        drawn = currentGame.dealHands();
        ServletContext context = getServletConfig().getServletContext();
        context.setAttribute("currentGame", currentGame);
    }

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

        if (currentGame == null || !currentGame.isInProgress()) {
            startNewGame();
        }

        request.setAttribute("Player", currentGame.getPlayer());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/gameScreen.jsp");
        dispatcher.forward(request, response);
    }
}
