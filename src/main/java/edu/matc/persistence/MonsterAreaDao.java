package edu.matc.persistence;

import edu.matc.entity.MonsterArea;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas Tolly on 2/2/16.
 */
public class MonsterAreaDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all monsterAreas
     *
     * @return All monsterAreas
     */
    public List<MonsterArea> getAllMonsterAreas() {
        List<MonsterArea> monsterAreas = new ArrayList<MonsterArea>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        monsterAreas = session.createCriteria(MonsterArea.class).list();
        return monsterAreas;
    }

    /**
     * retrieve an monsterArea given their monsterAreaId
     *
     * @param monsterAreaId the monsterArea's monsterAreaId
     * @return monsterArea
     */
    public MonsterArea getMonsterArea(int monsterAreaId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        MonsterArea monsterArea = (MonsterArea) session.get(MonsterArea.class, monsterAreaId);
        return monsterArea;
    }

    /**
     * add an monsterArea
     *
     * @param monsterArea
     * @return the monsterAreaId of the inserted record
     */
    public int addMonsterArea(MonsterArea monsterArea) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int monsterAreaId = (int)session.save(monsterArea);
        transaction.commit();
        return monsterAreaId;
    }

    /**
     * delete an monsterArea by monsterAreaId
     * @param monsterAreaId the monsterArea's monsterAreaId
     */
    public void deleteMonsterArea(int monsterAreaId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        MonsterArea monsterArea = (MonsterArea) session.get(MonsterArea.class, monsterAreaId);
        session.delete(monsterArea);
        transaction.commit();
    }


    /**
     * Update the monsterArea
     * @param monsterArea
     */
    public void updateMonsterArea(MonsterArea monsterArea) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(monsterArea);
        transaction.commit();
    }
}
