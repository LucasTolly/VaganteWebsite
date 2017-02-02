/**
 * This class is the model for the Background table.
 */
public class Background {

    private int backgroundId;
    private int classId;
    private int secretId;
    private String description;
    private boolean unlockedBySecret;

    /**
     * Empty constructor currently
     */
    public Background() {

    }

    /**
     * This is the getter for the Background's id
     * @return the Background's id
     */
    public int getBackgroundId() {
        return backgroundId;
    }

    /**
     * This is the getter for the Background's class' id
     * @return the Background's class' id
     */
    public int getClassId() {
        return classId;
    }

    /**
     * This is the getter for the Background's secret's id
     * @return the Background's secret's id
     */
    public int getSecretId() {
        return secretId;
    }

    /**
     * This is the getter for the Background's description
     * @return the Background's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * This is the getter for the Background's unlocked by secret
     * flag
     * @return the Background's unlocked by secret flag
     */
    public boolean isUnlockedBySecret() {
        return unlockedBySecret;
    }
}