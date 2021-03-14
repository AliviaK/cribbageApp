package edu.matc.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsDAOTest {

    @Test
    void getDeck() throws JsonProcessingException {
        DeckOfCardsDAO dao = new DeckOfCardsDAO();
        assertTrue(dao.getDeck().isSuccess());
        assertTrue(dao.getDeck().isShuffled());
        assertEquals(52, dao.getDeck().getRemaining());
    }
}