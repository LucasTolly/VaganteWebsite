package edu.matc.persistence;

import edu.matc.entity.BackgroundClass;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas Tolly on 2/2/16.
 */
public class BackgroundClassDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all backgroundClasses
     *
     * @return All backgroundClasses
     */
    public List<BackgroundClass> getAllBackgroundClasses() {
        List<BackgroundClass> backgroundClasses = new ArrayList<BackgroundClass>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        backgroundClasses = session.createCriteria(BackgroundClass.class).list();
        return backgroundClasses;
    }

    /**
     * retrieve an backgroundClass given their backgroundClassId
     *
     * @param backgroundClassId the backgroundClass's backgroundClassId
     * @return backgroundClass
     */
    public BackgroundClass getBackgroundClass(int backgroundClassId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        BackgroundClass backgroundClass = (BackgroundClass) session.get(BackgroundClass.class, backgroundClassId);
        return backgroundClass;
    }

    /**
     * add an backgroundClass
     *
     * @param backgroundClass
     * @return the backgroundClassId of the inserted record
     */
    public int addBackgroundClass(BackgroundClass backgroundClass) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int backgroundClassId = (int)session.save(backgroundClass);
        transaction.commit();
        return backgroundClassId;
    }

    /**
     * delete an backgroundClass by backgroundClassId
     * @param backgroundClassId the backgroundClass's backgroundClassId
     */
    public void deleteBackgroundClass(int backgroundClassId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        BackgroundClass backgroundClass = (BackgroundClass) session.get(BackgroundClass.class, backgroundClassId);
        session.delete(backgroundClass);
        transaction.commit();
    }


    /**
     * Update the backgroundClass
     * @param backgroundClass
     */
    public void updateBackgroundClass(BackgroundClass backgroundClass) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(backgroundClass);
        transaction.commit();
    }
}
