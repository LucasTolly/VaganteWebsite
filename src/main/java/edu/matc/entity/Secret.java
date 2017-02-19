package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent an affinity.
 *
 * @author Lucas Tolly
 * Created: 2/6/2017
 */
@Entity
@Table(name = "secret")
public class Secret {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    @Column(name = "SecretId")
    private int secretId;

    @Column(name = "Title")
    private String title;

    @Column(name = "UnlockMethod")
    private String unlockMethod;

    @Column(name = "Description")
    private String description;

    /**
     * Empty constructor
     */
    public Secret() {

    }

    /**
     * This constructor takes four parameters and sets them to the
     * instance variables
     * @param secretId
     * @param title
     * @param unlockMethod
     * @param description
     */
    public Secret(int secretId, String title, String unlockMethod, String description) {
        this.secretId = secretId;
        this.title = title;
        this.unlockMethod = unlockMethod;
        this.description = description;
    }

    /**
     * Gets the secret's id
     * @return
     */
    public int getSecretId() {
        return secretId;
    }

    /**
     * Sets the secret's id
     * @param secretId
     */
    public void setSecretId(int secretId) {
        this.secretId = secretId;
    }

    /**
     * Gets the secret's title
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the secret's title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the secret's unlock method
     * @return
     */
    public String getUnlockMethod() {
        return unlockMethod;
    }

    /**
     * Sets the secret's unlock method
     * @param unlockMethod
     */
    public void setUnlockMethod(String unlockMethod) {
        this.unlockMethod = unlockMethod;
    }

    /**
     * Gets the secret's description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the secret's description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
