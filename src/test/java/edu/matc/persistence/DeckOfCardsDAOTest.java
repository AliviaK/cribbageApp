package edu.matc.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.matc.entity.Game;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsDAOTest {
    DeckOfCardsDAO dao = null;

    @BeforeEach
    void setUp() {
        dao = new DeckOfCardsDAO();
    }
    /**
    @Test
    void getDeck() throws JsonProcessingException {
        assertTrue(dao.getDeck().isSuccess());
        assertEquals("urwz20x4b8z7", dao.getDeck().getDeckId());
    }*/
}