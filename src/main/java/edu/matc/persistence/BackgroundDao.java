package edu.matc.persistence;

import edu.matc.entity.Background;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas Tolly on 2/2/16.
 */
public class BackgroundDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all backgrounds
     *
     * @return All backgrounds
     */
    public List<Background> getAllBackgrounds() {
        List<Background> backgrounds = new ArrayList<Background>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        backgrounds = session.createCriteria(Background.class).list();
        return backgrounds;
    }

    /**
     * retrieve an background given their backgroundId
     *
     * @param backgroundId the background's backgroundId
     * @return background
     */
    public Background getBackground(int backgroundId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Background background = (Background) session.get(Background.class, backgroundId);
        return background;
    }

    /**
     * add an background
     *
     * @param background
     * @return the backgroundId of the inserted record
     */
    public int addBackground(Background background) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int backgroundId = (int)session.save(background);
        transaction.commit();
        return backgroundId;
    }

    /**
     * delete an background by backgroundId
     * @param backgroundId the background's backgroundId
     */
    public void deleteBackground(int backgroundId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Background background = (Background) session.get(Background.class, backgroundId);
        session.delete(background);
        transaction.commit();
    }


    /**
     * Update the background
     * @param background
     */
    public void updateBackground(Background background) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(background);
        transaction.commit();
    }
}
