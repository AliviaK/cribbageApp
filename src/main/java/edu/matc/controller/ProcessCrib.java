package edu.matc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.matc.deckOfCards.CardsItem;
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
import java.util.Iterator;

@WebServlet(
        urlPatterns = {"/processCrib"}
)
public class ProcessCrib extends HttpServlet {
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
        ServletContext context = getServletConfig().getServletContext();
        ActiveGame currentGame = (ActiveGame) context.getAttribute("currentGame");

        String[] values = request.getParameterValues("cardsForCrib[]");
        for (int i = 0; i < values.length; i++) {
            String valueOfCard = values[i];
            CardsItem card = currentGame.getPlayer().discardFromHand(valueOfCard);
            currentGame.addToCrib(card);
            logger.info(currentGame.getCrib());
        }

        request.setAttribute("cardsAfterCrib", currentGame.getPlayer());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/gameScreen2.jsp");
        dispatcher.forward(request, response);
    }
}
