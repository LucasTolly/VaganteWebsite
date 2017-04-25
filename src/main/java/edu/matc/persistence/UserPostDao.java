package edu.matc.persistence;

import edu.matc.entity.UserPost;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas Tolly on 2/2/16.
 */
public class UserPostDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all userPosts
     *
     * @return All userPosts
     */
    public List<UserPost> getAllUserPosts() {
        List<UserPost> userPosts = new ArrayList<UserPost>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        userPosts = session.createCriteria(UserPost.class).list();
        return userPosts;
    }

    /**
     * retrieve an userPost given their postId
     *
     * @param postId the userPost's postId
     * @return userPost
     */
    public UserPost getUserPost(int postId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        UserPost userPost = (UserPost) session.get(UserPost.class, postId);
        return userPost;
    }

    /**
     * add an userPost
     *
     * @param userPost
     * @return the postId of the inserted record
     */
    public int addUserPost(UserPost userPost) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int postId = (int)session.save(userPost);
        transaction.commit();
        return postId;
    }

    /**
     * delete an userPost by postId
     * @param postId the userPost's postId
     */
    public void deleteUserPost(int postId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        UserPost userPost = (UserPost) session.get(UserPost.class, postId);
        session.delete(userPost);
        transaction.commit();
    }


    /**
     * Update the userPost
     * @param userPost
     */
    public void updateUserPost(UserPost userPost) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(userPost);
        transaction.commit();
    }
}
