package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;

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
     * Instantiates a new User
     * @param id the int user id
     * @param userName the string user username
     * @param password the string user password
     * @param firstName the string user first name
     * @param lastName the string user last name
     */
    public User(String userName, String password, String firstName,
                String lastName, int id) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    /**
     * @return user password
     */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return username for login
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the string user's username
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return user id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the int user's id
     */
    public void setId(int id) {
        this.id = id;
    }
}
