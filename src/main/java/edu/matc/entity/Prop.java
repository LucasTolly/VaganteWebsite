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
@Table(name = "Prop")
public class Prop {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    @Column(name = "PropId")
    private int propId;

    @Column(name = "Type")
    private String type;

    @Column(name = "Description")
    private String description;

    /**
     * Empty constructor
     */
    public Prop() {

    }

    /**
     * This constructor takes three parameters and sets them to the
     * instance variables
     * @param propId
     * @param type
     * @param description
     */
    public Prop(int propId, String type, String description) {
        this.propId = propId;
        this.type = type;
        this.description = description;
    }

    /**
     * Gets the prop's id
     * @return
     */
    public int getPropId() {
        return propId;
    }

    /**
     * Sets the prop's id
     * @param propId
     */
    public void setPropId(int propId) {
        this.propId = propId;
    }

    /**
     * Gets the prop's type
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the prop's type
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the prop's description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the prop's description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
