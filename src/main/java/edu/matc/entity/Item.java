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
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    @Column(name = "ItemId")
    private int itemId;

    @Column(name = "Title")
    private String title;

    @Column(name = "Type")
    private String type;

    @Column(name = "Description")
    private String description;

    /**
     * Empty constructor
     */
    public Item() {

    }

    /**
     * This constructor takes four parameters, setting them to the
     * instance variables
     * @param itemId
     * @param title
     * @param type
     * @param description
     */
    public Item(int itemId, String title, String type, String description) {
        this.itemId = itemId;
        this.title = title;
        this.type = type;
        this.description = description;
    }

    /**
     * Gets the item's id
     * @return
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * Sets the item's id
     * @param itemId
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * Gets the item's title
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the item's title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the item's type
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the item's type
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the item's description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the item's description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
