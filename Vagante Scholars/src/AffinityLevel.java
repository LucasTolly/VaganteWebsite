/**
 * Lucas Tolly
 * 2/2/2017
 * This class is the mdoel for the AffinityLevel table.
 */
public class AffinityLevel {

    private int affinityLevelId;
    private int classAffinityId;
    private int level;
    private String description;

    /**
     * Empty constructor currently
     */
    public AffinityLevel() {

    }

    /**
     * This is a getter for the affinity level's id
     * @return the affinity level's id
     */
    public int getAffinityLevelId() {
        return affinityLevelId;
    }

    /**
     * This is a getter for the affinity level's class' id
     * @return the affinity level's class' id
     */
    public int getClassAffinityId() {
        return classAffinityId;
    }

    /**
     * This is a getter for the affinity level's level
     * @return the affinity level's level
     */
    public int getLevel() {
        return level;
    }

    /**
     * This is a getter for the affinity level's description
     * @return the affinity level's description
     */
    public int getDescription() {
        return description;
    }
}