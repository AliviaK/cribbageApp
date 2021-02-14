package edu.matc.persistence;

import edu.matc.entity.User;
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
    }

    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(2, users.size());
    }

    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = dao.getByPropertyLike("userName","j");
        assertEquals(1, users.size());
    }

    @Test
    void getByIdSuccess() {
        User retrievedUser = dao.getById(1000);
        assertNotNull(retrievedUser);
    }
}