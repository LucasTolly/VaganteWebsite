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
@Table(name = "backgroundclass")
public class BackgroundClass {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    @Column(name = "BackgroundClassId")
    private int backgroundClassId;

    @Column(name = "ClassId")
    private int classId;

    @Column(name = "BackgroundId")
    private int backgroundId;

    /**
     * Empty constructor
     */
    public BackgroundClass() {

    }

    /**
     * This constructor takes three parameters and sets them to the
     * instance variables
     * @param backgroundClassId
     * @param classId
     * @param backgroundId
     */
    public BackgroundClass(int backgroundClassId, int classId, int backgroundId) {
        this.backgroundClassId = backgroundClassId;
        this.classId = classId;
        this.backgroundId = backgroundId;
    }

    /**
     * Gets the backgroundclass's id
     * @return
     */
    public int getBackgroundClassId() {
        return backgroundClassId;
    }

    /**
     * Sets the backgroundclass's id
     * @param backgroundClassId
     */
    public void setBackgroundClassId(int backgroundClassId) {
        this.backgroundClassId = backgroundClassId;
    }

    /**
     * Gets the background class's class' id
     * @return
     */
    public int getClassId() {
        return classId;
    }

    /**
     * Sets the backgroundclass's class' id
     * @param classId
     */
    public void setClassId(int classId) {
        this.classId = classId;
    }

    /**
     * Gets the backgroundclass's background's id
     * @return
     */
    public int getBackgroundId() {
        return backgroundId;
    }

    /**
     * Sets the backgroundclass's background's id
     * @param backgroundId
     */
    public void setBackgroundId(int backgroundId) {
        this.backgroundId = backgroundId;
    }
}
