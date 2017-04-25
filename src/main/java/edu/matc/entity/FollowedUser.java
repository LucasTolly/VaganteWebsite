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
@Table(name = "FollowedUser")
public class FollowedUser {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    @Column(name = "FollowedUserId")
    private int followedUserId;

    @Column(name = "FollowedUser")
    private int followedUser;

    @Column(name = "FollowingUser")
    private int followingUser;

    /**
     * Empty constructor
     */
    public FollowedUser() {

    }

    /**
     * Constructor that takes in four parameters to immediately set
     * to the Affinity's instance variables
     * @param followedUserId
     * @param followedUser
     * @param followingUser
     */
    public FollowedUser(int followedUserId, int followedUser, int followingUser) {
        this.followedUserId = followedUserId;
        this.followedUser = followedUser;
        this.followingUser = followingUser;
    }

    /**
     * Getter for followedUserId
     * @return
     */
    public int getFollowedUserId() {
        return followedUserId;
    }

    /**
     * Setter for followedUserId
     * @param followedUserId
     */
    public void setFollowedUserId(int followedUserId) {
        this.followedUserId = followedUserId;
    }

    /**
     * Getter for followedUser
     * @return
     */
    public int getFollowedUser() {
        return followedUser;
    }

    /**
     * Setter for followedUser
     * @param followedUser
     */
    public void setFollowedUser(int followedUser) {
        this.followedUser = followedUser;
    }

    /**
     * Getter for followingUser
     * @return
     */
    public int getFollowingUser() {
        return followingUser;
    }

    /**
     * Setter for followingUser
     * @param followingUser
     */
    public void setFollowingUser(int followingUser) {
        this.followingUser = followingUser;
    }
}
