package edu.matc.persistence;

import edu.matc.entity.ItemProp;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas Tolly on 2/2/16.
 */
public class ItemPropDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all itemProps
     *
     * @return All itemProps
     */
    public List<ItemProp> getAllItemProps() {
        List<ItemProp> itemProps = new ArrayList<ItemProp>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        itemProps = session.createCriteria(ItemProp.class).list();
        return itemProps;
    }

    /**
     * retrieve an itemProps given their itemPropId
     *
     * @param itemPropId the itemProps's itemPropId
     * @return itemProps
     */
    public ItemProp getItemProp(int itemPropId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        ItemProp itemProps = (ItemProp) session.get(ItemProp.class, itemPropId);
        return itemProps;
    }

    /**
     * add an itemProps
     *
     * @param itemProps
     * @return the itemPropId of the inserted record
     */
    public int addItemProp(ItemProp itemProps) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int itemPropId = (int)session.save(itemProps);
        transaction.commit();
        return itemPropId;
    }

    /**
     * delete an itemProps by itemPropId
     * @param itemPropId the itemProps's itemPropId
     */
    public void deleteItemProp(int itemPropId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        ItemProp itemProps = (ItemProp) session.get(ItemProp.class, itemPropId);
        session.delete(itemProps);
        transaction.commit();
    }


    /**
     * Update the itemProps
     * @param itemProps
     */
    public void updateItemProp(ItemProp itemProps) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(itemProps);
        transaction.commit();
    }
}
