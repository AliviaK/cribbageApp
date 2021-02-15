package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;

/**
 * This class represents users in the Cribbage app. Users have a username, password, and auto-generated ID used for
 * identification and keeping score records.
 *
 */

@Entity(name = "User")
@Table(name = "user")
public class User {

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    /**
     * Instantiates a new User
     */
    public User() {
    }

    /**
     * Instantiates a new User with user inserted username and password
     * @param userName
     * @param password
     */
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * Instantiates a new User
     * @param id the int user id
     * @param userName the string user username
     * @param password the string user password
     */
    public User(String userName, String password, int id) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    /**
     * Gets the user password
     * @return user password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the user password
     * @param password the password to be retrieved
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the user name
     * @return username for login
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user name
     * @param userName the string user's username
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the user id
     * @return user id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the user id
     * @param id the int user's id
     */
    public void setId(int id) {
        this.id = id;
    }
}
