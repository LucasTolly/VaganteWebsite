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
@Table(name = "UserPost")
public class UserPost {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    @Column(name = "PostId")
    private int postId;

    @Column(name = "UserId")
    private int userId;

    /**
     * Empty constructor
     */
    public UserPost() {

    }

    /**
     * Constructor that takes in four parameters to immediately set
     * to the Affinity's instance variables
     * @param postId
     * @param userId
     */
    public UserPost(int postId, int userId) {
        this.postId = postId;
        this.userId = userId;
    }

    /**
     * Getter for postId
     * @return
     */
    public int getPostId() {
        return postId;
    }

    /**
     * Setter for postId
     * @param postId
     */
    public void setPostId(int postId) {
        this.postId = postId;
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
}
