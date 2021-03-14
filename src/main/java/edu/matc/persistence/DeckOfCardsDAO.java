package edu.matc.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.deckOfCards.Deck;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class DeckOfCardsDAO {
    public Deck getDeck() throws JsonProcessingException {
        final Logger logger = LogManager.getLogger(PropertiesLoader.class);
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1");
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
}
