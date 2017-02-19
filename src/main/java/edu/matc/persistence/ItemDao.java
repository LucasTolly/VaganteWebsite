package edu.matc.persistence;

import edu.matc.entity.Item;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas Tolly on 2/2/16.
 */
public class ItemDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all items
     *
     * @return All items
     */
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<Item>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        items = session.createCriteria(Item.class).list();
        return items;
    }

    /**
     * retrieve an item given their itemId
     *
     * @param itemId the item's itemId
     * @return item
     */
    public Item getItem(int itemId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Item item = (Item) session.get(Item.class, itemId);
        return item;
    }

    /**
     * add an item
     *
     * @param item
     * @return the itemId of the inserted record
     */
    public int addItem(Item item) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int itemId = (int)session.save(item);
        transaction.commit();
        return itemId;
    }

    /**
     * delete an item by itemId
     * @param itemId the item's itemId
     */
    public void deleteItem(int itemId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Item item = (Item) session.get(Item.class, itemId);
        session.delete(item);
        transaction.commit();
    }


    /**
     * Update the item
     * @param item
     */
    public void updateItem(Item item) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(item);
        transaction.commit();
    }
}
