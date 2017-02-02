/**
 * This class is the model for the AreaProp table.
 */
public class AreaProp {

    private int areaPropId;
    private int areaId;
    private int propId;

    /**
     * Empty constructor currently
     */
    public AreaProp() {

    }

    /**
     * This is the getter for the AreaProp's id
     * @return the AreaProp's id
     */
    public int getAreaPropId() {
        return AreaPropId;
    }

    /**
     * This is the getter for the AreaProp's area's id
     * @return the AreaProp's area's id
     */
    public int getAreaId() {
        return AreaId;
    }

    /**
     * This is the getter for the AreaProp's prop's id
     * @return the AreaProp's prop's id
     */
    public int getPropId() {
        return PropId;
    }
}