package edu.matc.persistence;

import edu.matc.entity.UserRoles;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas Tolly on 2/2/16.
 */
public class UserRolesDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * add an userRoles
     *
     * @param userRoles
     * @return the userRolesName of the inserted record
     */
    public String addUserRoles(UserRoles userRoles) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String userRolesName = (String)session.save(userRoles);
        transaction.commit();
        return userRolesName;
    }
}
