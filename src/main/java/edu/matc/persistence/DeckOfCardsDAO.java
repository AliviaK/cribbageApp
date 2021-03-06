package edu.matc.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.deckOfCards.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.json.Json;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class DeckOfCardsDAO {
    public Deck getNewDeck() throws JsonProcessingException {
        final Logger logger = LogManager.getLogger(PropertiesLoader.class);
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://deckofcardsapi.com/api/deck/new/shuffle/");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Deck deck = null;
        try {
            deck = mapper.readValue(response, Deck.class);
        } catch (JsonProcessingException e) {
            logger.error("Error processing request", e);
        }
        return deck;
    }

    public Deck shuffleDeck(String deckId) throws JsonProcessingException {
        final Logger logger = LogManager.getLogger(PropertiesLoader.class);
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://deckofcardsapi.com/api/deck/" + deckId + "/shuffle/");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Deck deck = null;
        try {
            deck = mapper.readValue(response, Deck.class);
        } catch (JsonProcessingException e) {
            logger.error("Error processing request", e);
        }
        return deck;
    }

    public DrawnCards drawCard(String deckId, int drawCount) throws JsonProcessingException {
        final Logger logger = LogManager.getLogger(PropertiesLoader.class);
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://deckofcardsapi.com/api/deck/" + deckId + "/draw/?count=" + drawCount);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        DrawnCards drawn = null;
        try {
            drawn = mapper.readValue(response, DrawnCards.class);
        } catch (JsonProcessingException e) {
            logger.error("Error processing request", e);
        }
        return drawn;
    }

    /** TODO: Eliminate duplicate code */
}
