package edu.matc.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.matc.deckOfCards.Deck;
import edu.matc.persistence.DeckOfCardsDAO;

public class ActiveGame {
    private int playerScore;
    private int cpuScore;
    private Deck deck;
    private DeckOfCardsDAO deckDao;

    public ActiveGame() throws JsonProcessingException {
        deckDao = new DeckOfCardsDAO();
        deck = deckDao.getNewDeck();
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getCpuScore() {
        return cpuScore;
    }

    public void setCpuScore(int cpuScore) {
        this.cpuScore = cpuScore;
    }

    public Deck getDeck() {
        return deck;
    }

    public String sayHi() {
        return "hi";
    }
}
