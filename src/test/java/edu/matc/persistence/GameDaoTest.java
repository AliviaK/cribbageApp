package edu.matc.persistence;

import edu.matc.entity.Game;
import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class to test GameDao methods
 */
class GameDaoTest {

    GenericDao genericDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Run set up tasks before each test
     */
    @BeforeEach
    void setUp() {

        genericDao = new GenericDao(Game.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Verify successful retrieval of a game
     */
    @Test
    void getByIdSuccess() {
        Game retrievedGame = (Game)genericDao.getById(8);
        assertNotNull(retrievedGame);
    }

    /**
     * Verify successful retrieval of a game or games matching exactly a searched term
     */
    @Test
    void getByPropertyEqual() {
        List<Game> games = genericDao.getByPropertyEqual("userScore","121");
        assertEquals(2, games.size());
        assertEquals(8, games.get(0).getGameId());
    }

    /**
     * Verifies successful update of a game
     */
    @Test
    void updateSuccess() {
        int newUserScore = 17;
        Game gameToUpdate = (Game)genericDao.getById(9);
        gameToUpdate.setUserScore(newUserScore);
        genericDao.saveOrUpdate(gameToUpdate);
        Game retrievedGame = (Game)genericDao.getById(9);
        assertEquals(17, retrievedGame.getUserScore());
    }

    /**
     * Verifies successful insert of a game
     */
    @Test
    void insertSuccess() {
        GenericDao userDao = new GenericDao(User.class);
        User user = (User) userDao.getById(1000);
        LocalDate gameEndTime = LocalDate.now();
        Game gameToInsert = new Game(user, 121, 82, gameEndTime);
        user.addGame(gameToInsert);
        int id = genericDao.insert(gameToInsert);

        assertNotEquals(0, id);
        Game insertedGame = (Game) genericDao.getById(id);
        assertEquals(121, insertedGame.getUserScore());
        assertNotNull(insertedGame.getUser());
        assertEquals("bobPlaysCards", insertedGame.getUser().getUserName());
    }

    /**
     * Verifies successful delete of a game
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(11));
        assertNull(genericDao.getById(11));
        logger.info(genericDao.getById(11));
    }

    /**
     * Verify successful retrieval of all games
     */
    @Test
    void getAllSuccess() {
        List<Game> games = genericDao.getAll();
        assertEquals(4,games.size());
    }
}