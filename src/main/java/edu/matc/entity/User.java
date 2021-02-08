package edu.matc.entity;

public class User {
    private int id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;

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
    public User(int id, String userName, String password, String firstName,
                String lastName) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @return user last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the string user's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return user first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the string user's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
