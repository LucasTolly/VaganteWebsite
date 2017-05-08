package edu.matc.entity;

import org.apache.log4j.Logger;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import edu.matc.persistence.Database;

/**
 * This class' purpose is to have a displayable version of the Monster class
 *
 * @author Lucas Tolly
 * Created: 2/6/2017
 */
public class MonsterDisplay extends Monster {

    private final Logger logger = Logger.getLogger(this.getClass());

    private String shortDescription;
    private Monster parentMonster;
    private List<Monster> childMonsters;
    private List<Area> areas;
    private Boolean hasParentMonster;
    private Boolean hasChildMonsters;

    /**
     * Empty Constructor
     */
    public MonsterDisplay() {

    }

    /**
     * This constructor takes a base monster class and builds off of
     * it to create a displayable monster
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

        Database database = Database.getInstance();
        Connection connection = null;
        childMonsters = new ArrayList<Monster>();
        areas = new ArrayList<Area>();
        Boolean instantiatedParentMonster = false;
        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();

            String areaSql = "SELECT Area.Name, Area.AreaId, Area.Description " +
                    "FROM (MonsterArea INNER JOIN Area ON MonsterArea.AreaId " +
                    "= Area.AreaId) WHERE MonsterArea.MonsterId = " +
                    String.valueOf(baseMonster.getMonsterId());
            ResultSet areaResults = selectStatement.executeQuery(areaSql);
            while (areaResults.next()) {
                Area area = createAreaFromResults(areaResults);
                areas.add(area);
            }

            String childMonstersSql = "SELECT * FROM monster WHERE ParentMonster = " +
                    String.valueOf(baseMonster.getMonsterId());
            ResultSet childResults = selectStatement.executeQuery(childMonstersSql);
            while (childResults.next()) {
                Monster childMonster = createMonsterFromResults(childResults);
                childMonsters.add(childMonster);
            }

            if (String.valueOf(baseMonster.getParentMonsterId()) != null) {
                String parentMonsterSql = "SELECT * FROM monster WHERE MonsterId = " +
                        String.valueOf(baseMonster.getParentMonsterId());
                ResultSet parentMonsterResults = selectStatement.executeQuery(parentMonsterSql);
                while (parentMonsterResults.next()) {
                    parentMonster = createMonsterFromResults(parentMonsterResults);
                    instantiatedParentMonster = true;
                }
            } else {
                parentMonster = new Monster();
            }
        } catch (SQLException e) {
            logger.error("SQL Error: ", e);
        } catch (Exception e) {
            logger.error("Error: ", e);
        }

        if (instantiatedParentMonster) {
            hasParentMonster = true;
        } else {
            hasParentMonster = false;
        }

        if (childMonsters.size() == 0) {
            hasChildMonsters = false;
        } else {
            hasChildMonsters = true;
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
    public String getShortDescription() { return this.shortDescription;}

    /**
     * Setter for parentMonster
     * @param monster
     */
    public void setParentMonster(Monster monster) {this.parentMonster = parentMonster; }

    /**
     * Getter for parentMonster
     * @return
     */
    public Monster getParentMonster() {
        return parentMonster;
    }

    /**
     * Setter for childMonsters
     * @param childMonsters
     */
    public void setChildMonsters(List<Monster> childMonsters) {
        this.childMonsters = childMonsters;
    }

    /**
     * Getter for childMonster
     * @return
     */
    public List<Monster> getChildMonsters() {
        return childMonsters;
    }

    /**
     * Setter for hasParentMonster
     * @param hasParentMonster
     */
    public void setHasParentMonster(Boolean hasParentMonster) {
        this.hasParentMonster = hasParentMonster;
    }

    /**
     * Getter for hasParentMonster
     * @return
     */
    public Boolean getHasParentMonster() {
        return hasParentMonster;
    }

    /**
     * Setter for hasChildMonsters
     * @param hasChildMonsters
     */
    public void setHasChildMonsters(Boolean hasChildMonsters) {
        this.hasChildMonsters = hasChildMonsters;
    }

    /**
     * Getter for hasChildMonsters
     * @return
     */
    public Boolean getHasChildMonsters() {
        return hasChildMonsters;
    }

    /**
     * Setter for areas
     * @param areas
     */
    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    /**
     * Getter for areas
     * @return
     */
    public List<Area> getAreas() {
        return areas;
    }

    /**
     * Creates a monster from a single results row set
     * @param results
     * @return Monster
     * @throws SQLException
     */
    private Monster createMonsterFromResults(ResultSet results) throws SQLException {
        Monster monster = new Monster();
        monster.setMonsterId(results.getInt("MonsterId"));
        monster.setName(results.getString("Name"));
        monster.setHp(results.getInt("HP"));

        return monster;
    }

    /**
     * Creates an area from a single results row set
     * @param results
     * @return Area
     * @throws SQLException
     */
    private Area createAreaFromResults(ResultSet results) throws SQLException {
        Area area = new Area();
        area.setAreaId(results.getInt("AreaId"));
        area.setName((results.getString("Name")));
        area.setDescription(results.getString("Description"));

        return area;
    }
}
