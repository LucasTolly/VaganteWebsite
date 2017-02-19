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
@Table(name = "monsterarea")
public class MonsterArea {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    @Column(name = "MonsterAreaId")
    private int monsterAreaId;

    @Column(name = "AreaId")
    private int areaId;

    @Column(name = "MonsterId")
    private int monsterId;

    /**
     * Empty constructor
     */
    public MonsterArea() {

    }

    /**
     * This constructor takes three parameters, setting them to the
     * instance variables
     * @param monsterAreaId
     * @param areaId
     * @param monsterId
     */
    public MonsterArea(int monsterAreaId, int areaId, int monsterId) {
        this.monsterAreaId = monsterAreaId;
        this.areaId = areaId;
        this.monsterId = monsterId;
    }

    /**
     * Gets the monsterarea's id
     * @return
     */
    public int getMonsterAreaId() {
        return monsterAreaId;
    }

    /**
     * Sets the monsterarea's id
     * @param monsterAreaId
     */
    public void setMonsterAreaId(int monsterAreaId) {
        this.monsterAreaId = monsterAreaId;
    }

    /**
     * Gets the monsterarea's area's id
     * @return
     */
    public int getAreaId() {
        return areaId;
    }

    /**
     * Sets the monsterarea's area's id
     * @param areaId
     */
    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    /**
     * Gets the monsterarea's monster's id
     * @return
     */
    public int getMonsterId() {
        return monsterId;
    }

    /**
     * Sets the monsterarea's monster's id
     * @param monsterId
     */
    public void setMonsterId(int monsterId) {
        this.monsterId = monsterId;
    }
}
