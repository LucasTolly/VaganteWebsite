package edu.matc.entity;

/**
 * This class' purpose is to have a displayable version of the MonsterServlet class
 *
 * @author Lucas Tolly
 * Created: 2/6/2017
 */
public class AreaDisplay extends Area {

    private String shortDescription;

    /**
     * Empty Constructor
     */
    public AreaDisplay() {

    }

    /**
     * This constructor takes a base monster class and builds off of
     * it to create a displable monster
     * @param baseArea
     */
    public AreaDisplay(Area baseArea) {
        setAreaId(baseArea.getAreaId());
        setName(baseArea.getName());
        setDescription(baseArea.getDescription());
        if (getDescription().length() > 100) {
            shortDescription = getDescription().substring(0, 99) + "...";
        } else {
            shortDescription = getDescription();
        }
    }

    /**
     * shortDescription Setter
     * @param shortDescription
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * shortDescription Getter
     * @return
     */
    public String getShortDescription() { return this.shortDescription; }
}
