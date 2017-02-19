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
@Table(name = "affinity")
public class Affinity {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    @Column(name = "ClassAffinityId")
    private int classAffinityId;

    @Column(name = "ClassId")
    private int classId;

    @Column(name = "AffinityName")
    private String affinityName;

    /**
     * Empty constructor
     */
    public Affinity() {

    }

    /**
     * Constructor that takes in four parameters to immediately set
     * to the Affinity's instance variables
     * @param classAffinityId
     * @param classId
     * @param affinityName
     */
    public Affinity(int classAffinityId, int classId, String affinityName) {
        this.classAffinityId = classAffinityId;
        this.classId = classId;
        this.affinityName = affinityName;
    }

    /**
     * Gets the primary key of the Affinity
     * @return the primary key
     */
    public int getClassAffinityId() {
        return classAffinityId;
    }

    /**
     * Sets the primary key of the Affinity
     * @param classAffinityId the primary key
     */
    public void setClassAffinityId(int classAffinityId) {
        this.classAffinityId = classAffinityId;
    }

    /**
     * Gets the Class foreign key of the Affinity
     * @return the Class foreign key
     */
    public int getClassId() {
        return classId;
    }

    /**
     * Sets the Class foreign key of the Affinity
     * @param classId
     */
    public void setClassId(int classId) {
        this.classId = classId;
    }

    /**
     * Gets the name of the Affinity
     * @return the Affinity name
     */
    public String getAffinityName() {
        return affinityName;
    }

    /**
     * Sets the name of the Affinity
     * @param affinityName the Affinity name
     */
    public void setAffinityName(String affinityName) {
        this.affinityName = affinityName;
    }
}
