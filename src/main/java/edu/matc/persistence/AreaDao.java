package edu.matc.persistence;

import edu.matc.entity.Area;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides easy access to the Area table in the
 * MySQL Database
 * @author tolly
 */
public class AreaDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all areas
     *
     * @return All areas
     */
    public List<Area> getAllAreas() {
        List<Area> areas = new ArrayList<Area>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        areas = session.createCriteria(Area.class).list();
        return areas;
    }

    /**
     * retrieve an area given their areaId
     *
     * @param areaId the area's areaId
     * @return area
     */
    public Area getArea(int areaId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Area area = (Area) session.get(Area.class, areaId);
        return area;
    }

    /**
     * add an area
     *
     * @param area
     * @return the areaId of the inserted record
     */
    public int addArea(Area area) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int areaId = (int)session.save(area);
        transaction.commit();
        return areaId;
    }

    /**
     * delete an area by areaId
     * @param areaId the area's areaId
     */
    public void deleteArea(int areaId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Area area = (Area) session.get(Area.class, areaId);
        session.delete(area);
        transaction.commit();
    }


    /**
     * Update the area
     * @param area
     */
    public void updateArea(Area area) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(area);
        transaction.commit();
    }
}
