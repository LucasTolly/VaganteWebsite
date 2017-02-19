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
@Table(name = "areaprop")
public class AreaProp {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    @Column(name = "AreaPropId")
    private int areaPropId;

    @Column(name = "AreaId")
    private int areaId;

    @Column(name = "PropId")
    private int propId;

    /**
     * Empty constructor
     */
    public AreaProp() {

    }

    /**
     * Constructor takes in three variables to make an AreaProp
     * @param areaPropId
     * @param areaId
     * @param propId
     */
    public AreaProp(int areaPropId, int areaId, int propId) {
        this.areaPropId = areaPropId;
        this.areaId = areaId;
        this.propId = propId;
    }

    /**
     * Gets the areaprop's id
     * @return
     */
    public int getAreaPropId() {
        return areaPropId;
    }

    /**
     * Set the areaprop's id
     * @param areaPropId
     */
    public void setAreaPropId(int areaPropId) {
        this.areaPropId = areaPropId;
    }

    /**
     * Get the areaprop's area's id
     * @return
     */
    public int getAreaId() {
        return areaId;
    }

    /**
     * Set the areaprop's area's id
     * @param areaId
     */
    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    /**
     * Get the areaprop's prop's id
     * @return
     */
    public int getPropId() {
        return propId;
    }

    /**
     * Set the areaprop's prop's id
     * @param propId
     */
    public void setPropId(int propId) {
        this.propId = propId;
    }
}
