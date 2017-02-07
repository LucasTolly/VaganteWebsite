/**
 * Lucas Tolly
 * 2/2/2017
 * This class is the model for the ItemProp table.
 */
public class ItemProp {

    private int itemPropId;
    private int itemId;
    private int propId;

    /**
     * Empty constructor currently
     */
    public ItemProp() {

    }

    /**
     * This is the getter for the ItemProp's id
     * @return the ItemProp's
     */
    public int getItemPropId() {
        return itemPropId;
    }

    /**
     * This is the getter for the ItemProp's item id
     * @return the ItemProp's
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * This is the getter for the ItemProp's prop id
     * @return the ItemProp's
     */
    public int getPropId() {
        return propId;
    }
}