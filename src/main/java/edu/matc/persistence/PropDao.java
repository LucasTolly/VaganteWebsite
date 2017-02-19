package edu.matc.persistence;

import edu.matc.entity.Prop;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas Tolly on 2/2/16.
 */
public class PropDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all props
     *
     * @return All props
     */
    public List<Prop> getAllProps() {
        List<Prop> props = new ArrayList<Prop>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        props = session.createCriteria(Prop.class).list();
        return props;
    }

    /**
     * retrieve an prop given their propId
     *
     * @param propId the prop's propId
     * @return prop
     */
    public Prop getProp(int propId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Prop prop = (Prop) session.get(Prop.class, propId);
        return prop;
    }

    /**
     * add an prop
     *
     * @param prop
     * @return the propId of the inserted record
     */
    public int addProp(Prop prop) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int propId = (int)session.save(prop);
        transaction.commit();
        return propId;
    }

    /**
     * delete an prop by propId
     * @param propId the prop's propId
     */
    public void deleteProp(int propId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Prop prop = (Prop) session.get(Prop.class, propId);
        session.delete(prop);
        transaction.commit();
    }


    /**
     * Update the prop
     * @param prop
     */
    public void updateProp(Prop prop) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(prop);
        transaction.commit();
    }
}
