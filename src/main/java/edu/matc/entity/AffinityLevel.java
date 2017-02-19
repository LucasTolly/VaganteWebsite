package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent an affinity level.
 *
 * @author Lucas Tolly
 * Created: 2/6/2017
 */
@Entity
@Table(name = "affinitylevel")
public class AffinityLevel {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    @Column(name = "AffinityLevelId")
    private int affinityLevelId;

    @Column(name = "ClassAffinityId")
    private int classAffinityId;

    @Column(name = "Level")
    private int level;

    @Column(name = "Description")
    private String description;

    /**
     * Empty constructor
     */
    public AffinityLevel() {

    }

    /**
     * Constructor that takes in four parameters to immediately set
     * to the Affinity Levels's instance variables
     * @param affinityLevelId
     * @param classAffinityId
     * @param level
     * @param description
     */
    public AffinityLevel(int affinityLevelId, int classAffinityId, int level, String description) {
        this.affinityLevelId = affinityLevelId;
        this.classAffinityId = classAffinityId;
        this.level = level;
        this.description = description;
    }

    /**
     * Gets the Affinity Level's Id
     * @return the Affinity Level's Id
     */
    public int getAffinityLevelId() {
        return affinityLevelId;
    }

    /**
     * Sets the Affinity Level's Id
     * @param affinityLevelId
     */
    public void setAffinityLevelId(int affinityLevelId) {
        this.affinityLevelId = affinityLevelId;
    }

    /**
     * Gets the Level's Affinity's Id
     * @return the Level's Affinity's Id
     */
    public int getClassAffinityId() {
        return classAffinityId;
    }

    /**
     * Sets the Level's Affinity's Id
     * @param classAffinityId the Level's Affinity's Id
     */
    public void setClassAffinityId(int classAffinityId) {
        this.classAffinityId = classAffinityId;
    }

    /**
     * Gets the affinity level's level
     * @return the affinity level's level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the affinity level's level
     * @param level the affinity level's level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Gets the affinity level's description
     * @return the affinity level's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * sets the affinity level's description
     * @param description the affinity level's description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
