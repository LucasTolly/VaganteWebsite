package edu.matc.entity;

import org.apache.log4j.Logger;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import edu.matc.persistence.Database;

/**
 * This class' purpose is to have a displayable version of the Area class
 *
 * @author Lucas Tolly
 * Created: 2/6/2017
 */
public class AreaDisplay extends Area {

    private final Logger logger = Logger.getLogger(this.getClass());

    private String shortDescription;
    private List<MonsterDisplay> monsters;

    /**
     * Empty Constructor
     */
    public AreaDisplay() {

    }

    /**
     * This constructor takes a base monster class and builds off of
     * it to create a displable area.
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

        Database database = Database.getInstance();
        Connection connection = null;
        monsters = new ArrayList<MonsterDisplay>();
        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();

            String monsterSql = "SELECT monster.Name, monster.MonsterId, monster.Description, monster.HP " +
                    "FROM (monsterarea INNER JOIN monster ON monsterarea.MonsterId " +
                    "= monster.MonsterId) WHERE monsterarea.AreaId = " +
                    String.valueOf(baseArea.getAreaId());
            ResultSet results = selectStatement.executeQuery(monsterSql);
            while (results.next()) {
                MonsterDisplay monster = createMonsterFromResultSet(results);
                monsters.add(monster);
            }

        } catch (SQLException e) {
            logger.error("Error: ", e);
        } catch (Exception e) {
            logger.error("Error: ", e);
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

    /**
     * Setter for monsters
     * @param monsters
     */
    public void setMonsters(List<MonsterDisplay> monsters) {
        this.monsters = monsters;
    }

    /**
     * Getter for monsters
     * @return
     */
    public List<MonsterDisplay> getMonsters() {
        return monsters;
    }

    /**
     * This method creates and returns a monster given a row of a
     * result set
     * @param results
     * @return Monster
     * @throws SQLException
     */
    public MonsterDisplay createMonsterFromResultSet(ResultSet results) throws SQLException {
        Monster monster = new Monster();
        monster.setMonsterId(results.getInt("MonsterId"));
        monster.setName(results.getString("Name"));
        monster.setDescription(results.getString("Description"));
        monster.setHp(results.getInt("HP"));

        MonsterDisplay monsterDisplay = new MonsterDisplay(monster);

        return monsterDisplay;
    }
}
