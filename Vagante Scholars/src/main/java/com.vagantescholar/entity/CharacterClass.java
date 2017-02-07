/**
 * Lucas Tolly
 * 2/2/2017
 * This class is the model for the Class Table (referenced as
 * CharacterClass to avoid reserved word issues).
 */
public class CharacterClass {

    private int classId;
    private String className;
    private int startingStrength;
    private int startingDexterity;
    private int startingVitality;
    private int startingIntelligence;
    private int startingLuck;

    /**
     * Empty constructor currently
     */
    public CharacterClass() {

    }

    /**
     * This is the getter for a class' id
     * @return the class' id
     */
    public int getClassId() {
        return classId;
    }

    /**
     * This is the getter for a class' name
     * @return the class' name
     */
    public String getClassName() {
        return className;
    }

    /**
     * This is the getter for a class' starting strength
     * @return the class' starting strength
     */
    public int getStartingStrength() {
        return startingStrength;
    }

    /**
     * This is the getter for a class' starting dexterity
     * @return the class' starting dexterity
     */
    public int getStartingDexterity() {
        return startingDexterity;
    }

    /**
     * This is the getter for a class' starting vitality
     * @return the class' starting vitality
     */
    public int getStartingVitality() {
        return startingVitality;
    }

    /**
     * This is the getter for a class' starting intelligence
     * @return the class' starting intelligence
     */
    public int getStartingIntelligence() {
        return startingIntelligence;
    }

    /**
     * This is the getter for a class' starting luck
     * @return the class' starting luck
     */
    public int getStartingLuck() {
        return startingLuck;
    }
}