package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent an area.
 *
 * @author Lucas Tolly
 * Created: 2/6/2017
 */
@Entity
@Table(name = "background")
public class Background {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    @Column(name = "BackGroundId")
    private int backgroundID;

    @Column(name = "ClassId")
    private int classId;

    @Column(name = "SecretId")
    private int secretId;

    @Column(name = "Description")
    private String description;

    @Column(name = "UnlockedBySecret")
    private boolean unlockedBySecret;

    /**
     * Empty constructor
     */
    public Background() {

    }

    /**
     * This constructor takes 5 parameters, setting them to the instance variables
     * @param backgroundID
     * @param classId
     * @param secretId
     * @param description
     * @param unlockedBySecret
     */
    public Background(int backgroundID, int classId, int secretId, String description, boolean unlockedBySecret) {
        this.backgroundID = backgroundID;
        this.classId = classId;
        this.secretId = secretId;
        this.description = description;
        this.unlockedBySecret = unlockedBySecret;
    }

    /**
     * Gets the background's id
     * @return
     */
    public int getBackgroundID() {
        return backgroundID;
    }

    /**
     * Sets the background's id
     * @param backgroundID
     */
    public void setBackgroundID(int backgroundID) {
        this.backgroundID = backgroundID;
    }

    /**
     * Gets the background's class's id
     * @return
     */
    public int getClassId() {
        return classId;
    }

    /**
     * Sets the background's class's id
     * @param classId
     */
    public void setClassId(int classId) {
        this.classId = classId;
    }

    /**
     * Gets the background's secret's id
     * @return
     */
    public int getSecretId() {
        return secretId;
    }

    /**
     * Sets the background's secret's id
     * @param secretId
     */
    public void setSecretId(int secretId) {
        this.secretId = secretId;
    }

    /**
     * Gets the background's description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the background's description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the background's isUnlockedBySecret
     * @return
     */
    public boolean isUnlockedBySecret() {
        return unlockedBySecret;
    }

    /**
     * Sets the background's isUnlockedBySecret
     * @param unlockedBySecret
     */
    public void setUnlockedBySecret(boolean unlockedBySecret) {
        this.unlockedBySecret = unlockedBySecret;
    }
}
