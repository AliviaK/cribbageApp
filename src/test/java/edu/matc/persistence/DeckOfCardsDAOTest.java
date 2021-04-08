package edu.matc.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.matc.deckOfCards.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsDAOTest {
    DeckOfCardsDAO dao = null;
    Deck sampleDeck = null;
    String sampleDeckId = "";

    @BeforeEach
    void setUp() throws JsonProcessingException {
        dao = new DeckOfCardsDAO();
        sampleDeck = dao.getNewDeck();
        sampleDeckId = sampleDeck.getDeckId();
    }

    @Test
    void getNewDeckTest() throws JsonProcessingException {
        assertTrue(dao.getNewDeck().isSuccess());
    }

    @Test
    void shuffleDeckTest() throws JsonProcessingException {
        assertEquals(true, dao.shuffleDeck(sampleDeckId).isShuffled());
    }

    @Test
    void drawCardsTest() throws JsonProcessingException {
        DrawnCards drawn = dao.drawCard(sampleDeckId, 5);
        assertEquals(47, drawn.getRemaining());
    }

    @Test
    void addToPlayerHandTest() throws JsonProcessingException {
        DrawnCards drawn = dao.drawCard(sampleDeckId, 5);
        PileCreation pile = dao.addToPile("PlayerHand", drawn);
        assertEquals(47, pile.getRemaining());

        DrawnCards drawn2 = dao.drawCard(sampleDeckId, 5);
        pile = dao.addToPile("CpuHand", drawn2);
        assertEquals(42, pile.getRemaining());
    }
}