package edu.matc.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.matc.deckOfCards.CardsItem;
import edu.matc.deckOfCards.Deck;
import edu.matc.deckOfCards.DrawnCards;
import edu.matc.persistence.DeckOfCardsDAO;

import java.util.HashMap;
import java.util.Map;

public class ActiveGame {
    private Deck deck;
    private DeckOfCardsDAO deckDao;
    private Player player;
    private Player cpu;
    private CardsItem cut;
    private Map<String, CardsItem> crib;
    private boolean inProgress;
    private int runningCount;
    private boolean playerDeal;
    private int round;

    public ActiveGame() { }

    // Getters and setters

    public Deck getDeck() {
        return deck;
    }

    public Player getPlayer() { return player; }

    public void setPlayer(Player player) { this.player = player; }

    public Player getCpu() { return cpu; }

    public void setCpu(Player cpu) { this.cpu = cpu; }

    public CardsItem getCut() { return cut; }

    public void setCut(CardsItem cut) { this.cut = cut; }

    public Map<String, CardsItem> getCrib() {
        return crib;
    }

    public void setCrib(Map<String, CardsItem> crib) {
        this.crib = crib;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    public int getRunningCount() { return runningCount; }

    public void setRunningCount(int runningCount) { this.runningCount = runningCount; }

    public boolean isPlayerDeal() { return playerDeal; }

    public void setPlayerDeal(boolean playerDeal) { this.playerDeal = playerDeal; }

    public int getRound() { return round; }

    public void setRound(int round) { this.round = round; }

    // Game logic
    public void startNewGame() throws JsonProcessingException {
        deckDao = new DeckOfCardsDAO();
        deck = deckDao.getNewDeck();
        player = new Player();
        cpu = new Player();
        crib = new HashMap<String, CardsItem>();
        inProgress = true;
        playerDeal = true;
        round = 1;
    }

    public void shuffleDeck() throws JsonProcessingException {
        deckDao.shuffleDeck(deck.getDeckId());
    }

    public void dealHands() throws JsonProcessingException {
        DrawnCards drawn = deckDao.drawCard(deck.getDeckId(), 13);

        for (int i = 0; i < drawn.getCards().size(); i++) {
            switch (i) {
                case 0: case 1: case 2: case 3: case 4: case 5:
                    player.addToHand(drawn.getCards().get(i));
                    break;
                case 6: case 7: case 8: case 9:
                    cpu.addToHand(drawn.getCards().get(i));
                    break;
                case 10: case 11:
                    addToCrib(drawn.getCards().get(i));
                    break;
                case 12:
                    cut = drawn.getCards().get(i);
                    break;
            }
        }
    }

    public void addToCrib(CardsItem card) {
        crib.put(card.getCode(), card);
    }
}
