package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a user.
 *
 * @author Lucas Tolly
 * Created: 2/6/2017
 */
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    @Column(name = "UserId")
    private int userId;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email")
    private String email;

    /**
     * Empty constructor
     */
    public User() {

    }

    /**
     * Constructor that takes in four parameters to immediately set
     * to the Affinity's instance variables
     * @param userId
     * @param username
     * @param password
     * @param email
     */
    public User(int userId, String username, String password, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    /**
     * Getter for userId
     * @return
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Setter for userId
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Getter for username
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter for username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter for password
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
