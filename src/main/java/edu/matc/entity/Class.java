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
@Table(name = "class")
public class Class {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    @Column(name = "ClassId")
    private int classId;

    @Column(name = "ClassName")
    private String className;

    @Column(name = "StartingStrength")
    private int startingStrength;

    @Column(name = "StartingDexterity")
    private int startingDexterity;

    @Column(name = "StartingVitality")
    private int startingVitality;

    @Column(name = "StartingIntelligence")
    private int startingIntelligence;

    @Column(name = "StartingLuck")
    private int startingLuck;

    /**
     * Empty constructor
     */
    public Class() {

    }

    /**
     * This constructor takes seven parameters, setting them to the instance variables
     * @param classId
     * @param className
     * @param startingStrength
     * @param startingDexterity
     * @param startingVitality
     * @param startingIntelligence
     * @param startingLuck
     */
    public Class(int classId, String className, int startingStrength, int startingDexterity, int startingVitality,
                 int startingIntelligence, int startingLuck) {
        this.classId = classId;
        this.className = className;
        this.startingStrength = startingStrength;
        this.startingDexterity = startingDexterity;
        this.startingVitality = startingVitality;
        this.startingIntelligence = startingIntelligence;
        this.startingLuck = startingLuck;
    }

    /**
     * Gets the class' id
     * @return
     */
    public int getClassId() {
        return classId;
    }

    /**
     * Sets the class' id
     * @param classId
     */
    public void setClassId(int classId) {
        this.classId = classId;
    }

    /**
     * Gets the class' name
     * @return
     */
    public String getClassName() {
        return className;
    }

    /**
     * Sets the class' name
     * @param className
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Gets the class' starting strength
     * @return
     */
    public int getStartingStrength() {
        return startingStrength;
    }

    /**
     * Sets the class' starting strength
     * @param startingStrength
     */
    public void setStartingStrength(int startingStrength) {
        this.startingStrength = startingStrength;
    }

    /**
     * Gets the class' starting dexterity
     * @return
     */
    public int getStartingDexterity() {
        return startingDexterity;
    }

    /**
     * Sets the class' starting dexterity
     * @param startingDexterity
     */
    public void setStartingDexterity(int startingDexterity) {
        this.startingDexterity = startingDexterity;
    }

    /**
     * Gets the class' starting vitality
     * @return
     */
    public int getStartingVitality() {
        return startingVitality;
    }

    /**
     * Sets the class' starting vitality
     * @param startingVitality
     */
    public void setStartingVitality(int startingVitality) {
        this.startingVitality = startingVitality;
    }

    /**
     * Gets the class' starting intelligence
     * @return
     */
    public int getStartingIntelligence() {
        return startingIntelligence;
    }

    /**
     * Sets the class' starting intelligence
     * @param startingIntelligence
     */
    public void setStartingIntelligence(int startingIntelligence) {
        this.startingIntelligence = startingIntelligence;
    }

    /**
     * Gets the class' starting luck
     * @return
     */
    public int getStartingLuck() {
        return startingLuck;
    }

    /**
     * Sets the class' starting luck
     * @param startingLuck
     */
    public void setStartingLuck(int startingLuck) {
        this.startingLuck = startingLuck;
    }
}
