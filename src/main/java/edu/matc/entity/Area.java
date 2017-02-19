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
@Table(name = "area")
public class Area {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    @Column(name = "AreaId")
    private int areaId;

    @Column(name = "Description")
    private String description;

    /**
     * Empty constructor
     */
    public Area() {

    }

    /**
     * Constructor that takes in four parameters to immediately set
     * to the Area's instance variables
     * @param areaId
     * @param description
     */
    public Area(int areaId, String description) {
        this.areaId = areaId;
        this.description = description;
    }

    /**
     * Gets the area's id
     * @return the area's id
     */
    public int getAreaId() {
        return areaId;
    }

    /**
     * Sets the area's id
     * @param areaId the area's id
     */
    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    /**
     * Gets the area's description
     * @return the area's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the area's description
     * @param description the area's description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
