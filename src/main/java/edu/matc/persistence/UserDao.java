package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides easy access to the User table in the
 * MySQL Database
 * @author tolly
 */
public class UserDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all users
     *
     * @return All users
     */
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        users = session.createCriteria(User.class).list();
        return users;
    }

    /**
     * retrieve an user given their username
     *
     * @param username the user's username
     * @return user
     */
    public User getUser(String username) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        User user = (User) session.get(User.class, username);
        return user;
    }

    /**
     * add an user
     *
     * @param user
     * @return the username of the inserted record
     */
    public String addUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String username = (String)session.save(user);
        transaction.commit();
        return username;
    }

    /**
     * delete an user by username
     * @param username the user's username
     */
    public void deleteUser(String username) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User user = (User) session.get(User.class, username);
        session.delete(user);
        transaction.commit();
    }


    /**
     * Update the user
     * @param user
     */
    public void updateUser(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
    }
}
