package edu.matc.persistence;

import edu.matc.entity.FollowedUser;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas Tolly on 2/2/16.
 */
public class FollowedUserDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all followedUsers
     *
     * @return All followedUsers
     */
    public List<FollowedUser> getAllFollowedUsers() {
        List<FollowedUser> followedUsers = new ArrayList<FollowedUser>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        followedUsers = session.createCriteria(FollowedUser.class).list();
        return followedUsers;
    }

    /**
     * retrieve an followedUser given their followedUserId
     *
     * @param followedUserId the followedUser's followedUserId
     * @return followedUser
     */
    public FollowedUser getFollowedUser(int followedUserId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        FollowedUser followedUser = (FollowedUser) session.get(FollowedUser.class, followedUserId);
        return followedUser;
    }

    /**
     * add an followedUser
     *
     * @param followedUser
     * @return the followedUserId of the inserted record
     */
    public int addFollowedUser(FollowedUser followedUser) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int followedUserId = (int)session.save(followedUser);
        transaction.commit();
        return followedUserId;
    }

    /**
     * delete an followedUser by followedUserId
     * @param followedUserId the followedUser's followedUserId
     */
    public void deleteFollowedUser(int followedUserId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        FollowedUser followedUser = (FollowedUser) session.get(FollowedUser.class, followedUserId);
        session.delete(followedUser);
        transaction.commit();
    }


    /**
     * Update the followedUser
     * @param followedUser
     */
    public void updateFollowedUser(FollowedUser followedUser) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(followedUser);
        transaction.commit();
    }
}
