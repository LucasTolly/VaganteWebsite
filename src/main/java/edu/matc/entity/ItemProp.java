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
@Table(name = "itemprop")
public class ItemProp {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    @Column(name = "ItemPropId")
    private int itemPropId;

    @Column(name = "ItemId")
    private int itemId;

    @Column(name = "PropId")
    private int propId;

    /**
     * Empty constructor
     */
    public ItemProp() {

    }

    /**
     * This constructor takes three parameters, setting them to the
     * instance variables
     * @param itemPropId
     * @param itemId
     * @param propId
     */
    public ItemProp(int itemPropId, int itemId, int propId) {
        this.itemPropId = itemPropId;
        this.itemId = itemId;
        this.propId = propId;
    }

    /**
     * Get the itemprop's id
     * @return
     */
    public int getItemPropId() {
        return itemPropId;
    }

    /**
     * Set the itemprop's id
     * @param itemPropId
     */
    public void setItemPropId(int itemPropId) {
        this.itemPropId = itemPropId;
    }

    /**
     * Get the itemprop's item's id
     * @return
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * Set the itemprop's item's id
     * @param itemId
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * Get the itemprop's prop's id
     * @return
     */
    public int getPropId() {
        return propId;
    }

    /**
     * Set the itemprop's prop's id
     * @param propId
     */
    public void setPropId(int propId) {
        this.propId = propId;
    }
}
