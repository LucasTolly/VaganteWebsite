package edu.matc.persistence;

import edu.matc.entity.Monster;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas Tolly on 2/2/16.
 */
public class MonsterDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all monsters
     *
     * @return All monsters
     */
    public List<Monster> getAllMonsters() {
        List<Monster> monsters = new ArrayList<Monster>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        monsters = session.createCriteria(Monster.class).list();
        return monsters;
    }

    /**
     * retrieve an monster given their monsterId
     *
     * @param monsterId the monster's monsterId
     * @return monster
     */
    public Monster getMonster(int monsterId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Monster monster = (Monster) session.get(Monster.class, monsterId);
        return monster;
    }

    /**
     * add an monster
     *
     * @param monster
     * @return the monsterId of the inserted record
     */
    public int addMonster(Monster monster) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int monsterId = (int)session.save(monster);
        transaction.commit();
        return monsterId;
    }

    /**
     * delete an monster by monsterId
     * @param monsterId the monster's monsterId
     */
    public void deleteMonster(int monsterId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Monster monster = (Monster) session.get(Monster.class, monsterId);
        session.delete(monster);
        transaction.commit();
    }


    /**
     * Update the monster
     * @param monster
     */
    public void updateMonster(Monster monster) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(monster);
        transaction.commit();
    }
}
