package edu.matc.persistence;

import edu.matc.entity.AreaProp;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas Tolly on 2/2/16.
 */
public class AreaPropDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all areaProps
     *
     * @return All areaProps
     */
    public List<AreaProp> getAllAreaProps() {
        List<AreaProp> areaProps = new ArrayList<AreaProp>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        areaProps = session.createCriteria(AreaProp.class).list();
        return areaProps;
    }

    /**
     * retrieve an areaProp given their areaPropId
     *
     * @param areaPropId the areaProp's areaPropId
     * @return areaProp
     */
    public AreaProp getAreaProp(int areaPropId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        AreaProp areaProp = (AreaProp) session.get(AreaProp.class, areaPropId);
        return areaProp;
    }

    /**
     * add an areaProp
     *
     * @param areaProp
     * @return the areaPropId of the inserted record
     */
    public int addAreaProp(AreaProp areaProp) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int areaPropId = (int)session.save(areaProp);
        transaction.commit();
        return areaPropId;
    }

    /**
     * delete an areaProp by areaPropId
     * @param areaPropId the areaProp's areaPropId
     */
    public void deleteAreaProp(int areaPropId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        AreaProp areaProp = (AreaProp) session.get(AreaProp.class, areaPropId);
        session.delete(areaProp);
        transaction.commit();
    }


    /**
     * Update the areaProp
     * @param areaProp
     */
    public void updateAreaProp(AreaProp areaProp) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(areaProp);
        transaction.commit();
    }
}
