package edu.matc.persistence;

import edu.matc.entity.AffinityLevel;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas Tolly on 2/2/16.
 */
public class AffinityLevelDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all affinityLevels
     *
     * @return All affinityLevels
     */
    public List<AffinityLevel> getAllAffinityLevel() {
        List<AffinityLevel> affinityLevels = new ArrayList<AffinityLevel>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        affinityLevels = session.createCriteria(AffinityLevel.class).list();
        return affinityLevels;
    }

    /**
     * retrieve an affinityLevel given their affinityLevelId
     *
     * @param affinityLevelId the affinityLevel's affinityLevelId
     * @return affinityLevel
     */
    public AffinityLevel getAffinityLevel(int affinityLevelId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        AffinityLevel affinityLevel = (AffinityLevel) session.get(AffinityLevel.class, affinityLevelId);
        return affinityLevel;
    }

    /**
     * add an affinityLevel
     *
     * @param affinityLevel
     * @return the affinityLevelId of the inserted record
     */
    public int addAffinityLevel(AffinityLevel affinityLevel) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int affinityLevelId = (int)session.save(affinityLevel);
        transaction.commit();
        return affinityLevelId;
    }

    /**
     * delete an affinityLevel by affinityLevelId
     * @param affinityLevelId the affinityLevel's affinityLevelId
     */
    public void deleteAffinityLevel(int affinityLevelId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        AffinityLevel affinityLevel = (AffinityLevel) session.get(AffinityLevel.class, affinityLevelId);
        session.delete(affinityLevel);
        transaction.commit();
    }


    /**
     * Update the affinityLevel
     * @param affinityLevel
     */
    public void updateAffinity(AffinityLevel affinityLevel) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(affinityLevel);
        transaction.commit();
    }
}
