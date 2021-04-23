package edu.matc.entity;

import edu.matc.deckOfCards.CardsItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Player {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private Map<String, CardsItem> hand;
    private Map<String, CardsItem> playedCards;
    private int score;

    public Player() {
        hand = new HashMap<String, CardsItem>();
        playedCards = new HashMap<String, CardsItem>();
        score = 0;
    }

    public Map<String, CardsItem> getHand() {
        return hand;
    }

    public void setHand(Map<String, CardsItem> hand) {
        this.hand = hand;
    }

    public Map<String, CardsItem> getPlayedCards() {
        return playedCards;
    }

    public void setPlayedCards(Map<String, CardsItem> playedCards) {
        this.playedCards = playedCards;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addToHand(CardsItem card) {
        hand.put(card.getCode(), card);
    }

    public void playCard(CardsItem card) {
        playedCards.put(card.getCode(), card);
    }

    public CardsItem discardFromHand(String cardCode) {
        CardsItem card = hand.remove(cardCode);
        return card;
    }


    // TODO Make method to return lowest value card in hand
    public String getLowestCard() {
        String lowestValue = "";
        for (String key : hand.keySet()) {
            lowestValue = key;
        }
        // Loop thru cards, replace lowest value card if lower than current. Return value
        return lowestValue;
    }
}
