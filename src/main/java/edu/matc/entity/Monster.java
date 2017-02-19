package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a monster.
 *
 * @author Lucas Tolly
 * Created: 2/6/2017
 */
@Entity
@Table(name = "monster")
public class Monster {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    @Column(name = "MonsterId")
    private int monsterId;

    @Column(name = "HP")
    private int hp;

    @Column(name = "Description")
    private String description;

    @Column(name = "name")
    private String name;

    /**
     * Empty constructor
     */
    public Monster() {

    }

    /**
     * This constructor takes three parameters, setting them to the
     * instance variables
     * @param monsterId
     * @param hp
     * @param description
     * @param name
     */
    public Monster(int monsterId, int hp, String description, String name) {
        this.monsterId = monsterId;
        this.hp = hp;
        this.description = description;
        this.name = name;
    }

    /**
     * Get the monster's id
     * @return
     */
    public int getMonsterId() {
        return monsterId;
    }

    /**
     * Set the monster's id
     * @param monsterId
     */
    public void setMonsterId(int monsterId) {
        this.monsterId = monsterId;
    }

    /**
     * Get the monster's hp
     * @return
     */
    public int getHp() {
        return hp;
    }

    /**
     * Set the monster's hp
     * @param hp
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Get the monster's description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the monster's description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the monster's name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set the monster's description
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
