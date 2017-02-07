/**
 * Lucas Tolly
 * 2/2/2017
 * This class is a model for the Item table.
 */
public class Item {

    private int itemId;
    private String title;
    private String description;
    private String type;

    /**
     * Empty constructor currently
     */
    public Item() {

    }

    /**
     * This is the getter for the Item's id
     * @return the Item's id
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * This is the getter for the Item's title
     * @return the Item's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * This is the getter for the Item's description
     * @return the Item's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This is the getter for the Item's type
     * @return the Item's type
     */
    public String getType() {
        return type;
    }
}