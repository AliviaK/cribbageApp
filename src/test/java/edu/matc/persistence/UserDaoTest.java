package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    UserDao dao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {

        dao = new UserDao();

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getById(1000);
        assertNotNull(retrievedUser);
    }

    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("userName","ird");
        assertEquals(1, users.size());
    }

    @Test
    void getByPropertyEqual() {
        List<User> users = dao.getByPropertyEqual("userName","bobPlaysCards");
        assertEquals(1, users.size());
    }

    @Test
    void updateSuccess() {
        String newUserName = "CribbageSuperStar380";
        User userToUpdate = dao.getById(1000);
        userToUpdate.setUserName(newUserName);
        dao.saveOrUpdate(userToUpdate);
        User retrievedUser = dao.getById(1000);
        assertEquals("CribbageSuperStar380", retrievedUser.getUserName());
    }

    @Test
    void insertSuccess() {
        User userToInsert = new User("catsAndDogs", "badpassword");
        int id = dao.insert(userToInsert);
        assertNotEquals(0, id);
        User insertedUser = dao.getById(id);
        assertEquals("catsAndDogs", insertedUser.getUserName());
    }

    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(1000));
        assertNull(dao.getById(1000));
    }

    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(2,users.size());
    }
}