package edu.matc.persistence;

import edu.matc.entity.Class;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas Tolly on 2/2/16.
 */
public class ClassDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all classes
     *
     * @return All classes
     */
    public List<Class> getAllClasses() {
        List<Class> classes = new ArrayList<Class>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        classes = session.createCriteria(Class.class).list();
        return classes;
    }

    /**
     * retrieve an classCustom given their classId
     *
     * @param classId the classCustom's classId
     * @return classCustom
     */
    public Class getClass(int classId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Class classCustom = (Class) session.get(Class.class, classId);
        return classCustom;
    }

    /**
     * add an classCustom
     *
     * @param classCustom
     * @return the classId of the inserted record
     */
    public int addClass(Class classCustom) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int classId = (int)session.save(classCustom);
        transaction.commit();
        return classId;
    }

    /**
     * delete an classCustom by classId
     * @param classId the classCustom's classId
     */
    public void deleteClass(int classId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Class classCustom = (Class) session.get(Class.class, classId);
        session.delete(classCustom);
        transaction.commit();
    }


    /**
     * Update the classCustom
     * @param classCustom
     */
    public void updateClass(Class classCustom) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(classCustom);
        transaction.commit();
    }
}
