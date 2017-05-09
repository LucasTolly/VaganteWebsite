package edu.matc.persistence;

import org.apache.log4j.Logger;
import edu.matc.persistence.AreaDao;
import edu.matc.entity.*;
import java.util.List;
import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

/**
 * This class tests all methods in AreaDao
 * @author tolly
 */
public class AreaDaoTest {

    public static AreaDao areaDao = new AreaDao();

    @BeforeClass
    public static void setup() {
        areaDao = new AreaDao();
        Area newArea = new Area();
        newArea.setName("TestTestTest");
        newArea.setDescription("This is the Test Area.");
        int areaId = areaDao.addArea(newArea);
    }

    @Test public void getAllAreas() throws Exception {
        List<Area> areas = areaDao.getAllAreas();

        Area insertedArea = new Area();
        insertedArea.setAreaId(0);

        for (Area area : areas) {
            if (area.getAreaId() > insertedArea.getAreaId()) {
                insertedArea = area;
            }
        }

        assertEquals("TestTestTest", insertedArea.getName());
    }

    @Test public void updateArea() throws Exception {
        List<Area> areas = areaDao.getAllAreas();
        Area areaToBeUpdated;
        for (Area area : areas) {
            if (area.getName().equals("TestTestTest")) {
                areaToBeUpdated = area;
                areaToBeUpdated.setDescription("Changing Description");
                areaDao.updateArea(areaToBeUpdated);
            }
        }
        List<Area> updatedAreas = areaDao.getAllAreas();
        Area updatedArea;
        Boolean updatedAreaFound = false;
        for (Area area : updatedAreas) {
            if (area.getDescription().equals("Changing Description")) {
                updatedAreaFound = true;
            }
        }
        assert(updatedAreaFound);
    }

    @Test public void getArea() throws Exception {
        List<Area> areas = areaDao.getAllAreas();
        int areaId = 0;
        for (Area area : areas) {
            if (area.getName().equals("TestTestTest")) {
                areaId = area.getAreaId();
            }
        }
        Area area = areaDao.getArea(areaId);
        assertEquals(area.getName(), "TestTestTest");
    }

    @AfterClass public static void deleteTestAreas() {
        List<Area> areas = areaDao.getAllAreas();
        for (Area area : areas) {
            if (area.getName().equals("TestTestTest")) {
                areaDao.deleteArea(area.getAreaId());
            }
        }
    }
}
