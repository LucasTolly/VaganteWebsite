package edu.matc.entity;

/**
 * This class' purpose is to have a displayable version of the Monster class
 *
 * @author Lucas Tolly
 * Created: 2/6/2017
 */
public class MonsterDisplay extends Monster {

    private String shortDescription;

    /**
     * Empty Constructor
     */
    public MonsterDisplay() {

    }

    /**
     * This constructor takes a base monster class and builds off of
     * it to create a displable monster
     * @param baseMonster
     */
    public MonsterDisplay(Monster baseMonster) {
        setMonsterId(baseMonster.getMonsterId());
        setName(baseMonster.getName());
        setHp(baseMonster.getHp());
        setDescription(baseMonster.getDescription());
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
