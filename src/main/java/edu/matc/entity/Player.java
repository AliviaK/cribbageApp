package edu.matc.entity;

import edu.matc.deckOfCards.CardsItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private Map<String, CardsItem> hand;

    public Player() {
        hand = new HashMap<String, CardsItem>();
    }

    public Map<String, CardsItem> getHand() {
        return hand;
    }

    public void setHand(Map<String, CardsItem> hand) {
        this.hand = hand;
    }

    public void addToHand(CardsItem card) {
        hand.put(card.getCode(), card);
    }

    public CardsItem discardFromHand(String cardCode) {
        CardsItem card = hand.remove(cardCode);
        return card;
    }
}
