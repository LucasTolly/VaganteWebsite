package edu.matc.persistence;

import edu.matc.entity.Area;
import edu.matc.persistence.AreaDao;
import edu.matc.entity.Monster;
import edu.matc.persistence.MonsterDao;
import edu.matc.entity.MonsterArea;
import edu.matc.persistence.MonsterAreaDao;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * This class test all methods in MonsterAreaDao
 * @author tolly
 */
public class MonsterAreaDaoTest {

    public static AreaDao areaDao = new AreaDao();
    public static MonsterDao monsterDao = new MonsterDao();
    public static MonsterAreaDao monsterAreaDao = new MonsterAreaDao();

    public static int staticMonsterId;

    @BeforeClass
    public static void setup() {
        areaDao = new AreaDao();
        Area newArea = new Area();
        newArea.setName("TestTestTest");
        newArea.setDescription("This is the Test Area.");
        int areaId = areaDao.addArea(newArea);

        Monster newMonster = new Monster();
        newMonster.setName("TestMonster");
        newMonster.setDescription("Test");;
        int monsterId = monsterDao.addMonster(newMonster);

        staticMonsterId = monsterId;

        MonsterArea newMonsterArea = new MonsterArea();
        newMonsterArea.setAreaId(areaId);
        newMonsterArea.setMonsterId(monsterId);
        int monsterAreaId = monsterAreaDao.addMonsterArea(newMonsterArea);
    }

    @Test public void getAllAreas() throws Exception {
        List<Area> areas = areaDao.getAllAreas();

        assert(areas.size() > 0);
    }

    @Test public void testGetMonsterArea() throws Exception {
        Area newArea = new Area();
        newArea.setName("TestTestTest");
        newArea.setDescription("Description");
        int areaId = areaDao.addArea(newArea);

        MonsterArea newMonsterArea = new MonsterArea();
        newMonsterArea.setMonsterId(staticMonsterId);
        newMonsterArea.setAreaId(areaId);

        int insertedMonsterAreaId = monsterAreaDao.addMonsterArea(newMonsterArea);

        MonsterArea insertedMonsterArea = monsterAreaDao.getMonsterArea(insertedMonsterAreaId);
        assertEquals(insertedMonsterArea.getAreaId(), areaId);
    }

    @AfterClass public static void deleteTestData() {
        List<MonsterArea> monsterAreas = monsterAreaDao.getAllMonsterAreas();
        for (MonsterArea monsterArea : monsterAreas) {
            if (monsterArea.getMonsterId() == staticMonsterId) {
                monsterAreaDao.deleteMonsterArea(monsterArea.getMonsterAreaId());
            }
        }
        List<Area> areas = areaDao.getAllAreas();
        for (Area area : areas) {
            if (area.getName().equals("TestTestTest")) {
                areaDao.deleteArea(area.getAreaId());
            }
        }
        List<Monster> monsters = monsterDao.getAllMonsters();
        for (Monster monster : monsters) {
            if (monster.getName().equals("TestMonster")) {
                monsterDao.deleteMonster(monster.getMonsterId());
            }
        }
    }
}
