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
@Table(name = "LikedPost")
public class LikedPost {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    @Column(name = "LikedPostId")
    private int likedPostId;

    @Column(name = "UserId")
    private int userId;

    @Column(name = "PostId")
    private int postId;

    /**
     * Empty constructor
     */
    public LikedPost() {

    }

    /**
     * Constructor that takes in four parameters to immediately set
     * to the Affinity's instance variables
     * @param postId
     * @param userId
     */
    public LikedPost(int likedPostId, int postId, int userId) {
        this.likedPostId = likedPostId;
        this.postId = postId;
        this.userId = userId;
    }

    /**
     * Getter for likedPostId
     * @return
     */
    public int getLikedPostId() {
        return likedPostId;
    }

    /**
     * Setter for likedPostId
     * @param likedPostId
     */
    public void setLikedPostId(int likedPostId) {
        this.likedPostId = likedPostId;
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
     * Getter for userId
     * @return
     */
    public int getPostId() {
        return postId;
    }

    /**
     * Setter for userId
     * @param postId
     */
    public void setPostId(int postId) {
        this.postId = postId;
    }
}
