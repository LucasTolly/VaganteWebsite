package edu.matc.persistence;

import edu.matc.entity.UserRoles;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides easy access to the UserRoles table in the
 * MySQL Database
 * @author tolly
 */
public class UserRolesDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * retrieve a user role given their username
     *
     * @param username the user role's username
     * @return monster
     */
    public UserRoles getUserRole(String username) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        UserRoles userRole = (UserRoles) session.get(UserRoles.class, username);
        return userRole;
    }

    /**
     * delete an user role by username
     * @param username the user's username
     */
    public void deleteUser(String username) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UserRoles userRoles = (UserRoles) session.get(UserRoles.class, username);
        session.delete(userRoles);
        transaction.commit();
    }

    /**
     * add a user role
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
