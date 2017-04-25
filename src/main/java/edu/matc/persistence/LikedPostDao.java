package edu.matc.persistence;

import edu.matc.entity.LikedPost;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas Tolly on 2/2/16.
 */
public class LikedPostDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all likedPosts
     *
     * @return All likedPosts
     */
    public List<LikedPost> getAllLikedPosts() {
        List<LikedPost> likedPosts = new ArrayList<LikedPost>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        likedPosts = session.createCriteria(LikedPost.class).list();
        return likedPosts;
    }

    /**
     * retrieve an likedPost given their likedPostId
     *
     * @param likedPostId the likedPost's likedPostId
     * @return likedPost
     */
    public LikedPost getLikedPost(int likedPostId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        LikedPost likedPost = (LikedPost) session.get(LikedPost.class, likedPostId);
        return likedPost;
    }

    /**
     * add an likedPost
     *
     * @param likedPost
     * @return the likedPostId of the inserted record
     */
    public int addLikedPost(LikedPost likedPost) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int likedPostId = (int)session.save(likedPost);
        transaction.commit();
        return likedPostId;
    }

    /**
     * delete an likedPost by likedPostId
     * @param likedPostId the likedPost's likedPostId
     */
    public void deleteLikedPost(int likedPostId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        LikedPost likedPost = (LikedPost) session.get(LikedPost.class, likedPostId);
        session.delete(likedPost);
        transaction.commit();
    }


    /**
     * Update the likedPost
     * @param likedPost
     */
    public void updateLikedPost(LikedPost likedPost) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(likedPost);
        transaction.commit();
    }
}
