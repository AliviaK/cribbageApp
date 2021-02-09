package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Access users in the user table.
 *
 * @author pwaite
 */
public class UserData {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public List<User> createUserSearch(String type, String searchTerm) {
        List<User> users = new ArrayList<>();
        Database database = Database.getInstance();
        Connection connection;
        String sql = "";
        switch (type) {
            case "all":
                sql = getAllUsers();
                break;
            case "last":
                sql = getUserByLast(searchTerm);
                break;
        }
        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            logger.error("SearchUser.getAllUsers()...SQL Exception: " + e);
        } catch (Exception e) {
            logger.error("SearchUser.getAllUsers()...Exception: " + e);
        }
        return users;
    }

    public String getAllUsers() {
        return "SELECT * FROM user";
    }

    public String getUserByLast(String lastName) {
        return "SELECT * FROM user where last_name like '" + lastName + "%'";
    }

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setLastName(results.getString("last_name"));
        user.setFirstName(results.getString("first_name"));
        user.setUserName(results.getString("user_name"));
        user.setId(results.getInt("id"));
        user.setDateOfBirth(results.getString("date_of_birth"));
        return user;
    }
}