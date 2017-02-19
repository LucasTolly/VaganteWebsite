package edu.matc.persistence;

import edu.matc.entity.Affinity;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas Tolly on 2/2/16.
 */
public class AffinityDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all affinities
     *
     * @return All affinities
     */
    public List<Affinity> getAllAffinities() {
        List<Affinity> affinities = new ArrayList<Affinity>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        affinities = session.createCriteria(Affinity.class).list();
        return affinities;
    }

    /**
     * retrieve an affinity given their classAffinityId
     *
     * @param classAffinityId the affinity's classAffinityId
     * @return affinity
     */
    public Affinity getAffinity(int classAffinityId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Affinity affinity = (Affinity) session.get(Affinity.class, classAffinityId);
        return affinity;
    }

    /**
     * add an affinity
     *
     * @param affinity
     * @return the classAffinityId of the inserted record
     */
    public int addAffinity(Affinity affinity) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int classAffinityId = (int)session.save(affinity);
        transaction.commit();
        return classAffinityId;
    }

    /**
     * delete an affinity by classAffinityId
     * @param classAffinityId the affinity's classAffinityId
     */
    public void deleteAffinity(int classAffinityId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Affinity affinity = (Affinity) session.get(Affinity.class, classAffinityId);
        session.delete(affinity);
        transaction.commit();
    }


    /**
     * Update the affinity
     * @param affinity
     */
    public void updateAffinity(Affinity affinity) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(affinity);
        transaction.commit();
    }
}
