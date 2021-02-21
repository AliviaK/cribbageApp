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
 * Test class to test User Dao methods
 */
class UserDaoTest {
    GenericDao genericDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Run set up tasks before each test
     */
    @BeforeEach
    void setUp() {

        genericDao = new GenericDao(User.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * Verify successful retrieval of a user
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User) genericDao.getById(1000);
        assertNotNull(retrievedUser);
    }

    /**
     * Verify successful retrieval of a user or users by like keyword
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = genericDao.getByPropertyLike("userName","ird");
        assertEquals(1, users.size());
    }

    /**
     * Verify successful retrieval of a user or users matching exactly a searched term
     */
    @Test
    void getByPropertyEqual() {
        List<User> users = genericDao.getByPropertyEqual("userName","bobPlaysCards");
        assertEquals(1, users.size());
    }

    /**
     * Verifies successful update of a user
     */
    @Test
    void updateSuccess() {
        String newUserName = "CribbageSuperStar380";
        User userToUpdate = (User) genericDao.getById(1000);
        userToUpdate.setUserName(newUserName);
        genericDao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User) genericDao.getById(1000);
        assertEquals("CribbageSuperStar380", retrievedUser.getUserName());
    }

    /**
     * Verifies successful insert of a user
     */
    @Test
    void insertSuccess() {
        User userToInsert = new User("catsAndDogs", "badpassword");
        int id = genericDao.insert(userToInsert);
        assertNotEquals(0, id);
        User insertedUser = (User) genericDao.getById(id);
        assertEquals("catsAndDogs", insertedUser.getUserName());
    }

    /**
     * Verifies successful insert of a user
     */
    @Test
    void insertWithGameSuccess() {
        User userToInsert = new User("catsAndDogs", "badpassword");
        LocalDate gameEndTime = LocalDate.now();
        Game game = new Game(userToInsert, 121, 82, gameEndTime);

        userToInsert.addGame(game);

        int id = genericDao.insert(userToInsert);

        assertNotEquals(0, id);
        User insertedUser = (User) genericDao.getById(id);
        assertEquals("catsAndDogs", insertedUser.getUserName());
        assertEquals(1, insertedUser.getGames().size());
    }

    /**
     * Verifies successful delete of a user
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(1001));
        assertNull(genericDao.getById(1001));
        logger.info(genericDao.getById(1001));
    }

    /**
     * Verify successful retrieval of all users
     */
    @Test
    void getAllSuccess() {
        List<User> users = genericDao.getAll();
        assertEquals(2,users.size());
    }
}