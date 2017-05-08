package edu.matc.persistence;

import org.apache.log4j.Logger;
import edu.matc.persistence.MonsterDao;
import edu.matc.entity.*;
import java.util.List;
import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

/**
 * Created by Lucas Tolly on 4/18/2017.
 */
public class MonsterClassesTest {

    public static MonsterDao monsterDao = new MonsterDao();

    @BeforeClass
    public static void setup() {
        monsterDao = new MonsterDao();
        Monster newMonster = new Monster();
        newMonster.setName("TestTestTest");
        newMonster.setDescription("This is the Test Monster.");
        int monsterId = monsterDao.addMonster(newMonster);
    }

    @Test public void getAllMonsters() throws Exception {
        List<Monster> monsters = monsterDao.getAllMonsters();

        Monster insertedMonster = new Monster();
        insertedMonster.setMonsterId(0);

        for (Monster monster : monsters) {
            if (monster.getMonsterId() > insertedMonster.getMonsterId()) {
                insertedMonster = monster;
            }
        }

        assertEquals("TestTestTest", insertedMonster.getName());
    }

    @Test public void updateMonster() throws Exception {
        List<Monster> monsters = monsterDao.getAllMonsters();
        Monster monsterToBeUpdated;
        for (Monster monster : monsters) {
            if (monster.getName().equals("TestTestTest")) {
                monsterToBeUpdated = monster;
                monsterToBeUpdated.setDescription("Changing Description");
                monsterDao.updateMonster(monsterToBeUpdated);
            }
        }
        List<Monster> updatedMonsters = monsterDao.getAllMonsters();
        Monster updatedMonster;
        Boolean updatedMonsterFound = false;
        for (Monster monster : updatedMonsters) {
            if (monster.getDescription().equals("Changing Description")) {
                updatedMonsterFound = true;
            }
        }
        assert(updatedMonsterFound);
    }

    @Test public void getMonster() throws Exception {
        List<Monster> monsters = monsterDao.getAllMonsters();
        int monsterId = 0;
        for (Monster monster : monsters) {
            if (monster.getName().equals("TestTestTest")) {
                monsterId = monster.getMonsterId();
            }
        }
        Monster monster = monsterDao.getMonster(monsterId);
        assertEquals(monster.getName(), "TestTestTest");
    }

    @AfterClass public static void deleteTestMonsters() {
        List<Monster> monsters = monsterDao.getAllMonsters();
        for (Monster monster : monsters) {
            if (monster.getName().equals("TestTestTest")) {
                monsterDao.deleteMonster(monster.getMonsterId());
            }
        }
    }
}
