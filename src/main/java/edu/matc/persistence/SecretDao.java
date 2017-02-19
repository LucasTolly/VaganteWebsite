package edu.matc.persistence;

import edu.matc.entity.Secret;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucas Tolly on 2/2/16.
 */
public class SecretDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all secrets
     *
     * @return All secrets
     */
    public List<Secret> getAllSecrets() {
        List<Secret> secrets = new ArrayList<Secret>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        secrets = session.createCriteria(Secret.class).list();
        return secrets;
    }

    /**
     * retrieve an secret given their secretId
     *
     * @param secretId the secret's secretId
     * @return secret
     */
    public Secret getSecret(int secretId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Secret secret = (Secret) session.get(Secret.class, secretId);
        return secret;
    }

    /**
     * add an secret
     *
     * @param secret
     * @return the secretId of the inserted record
     */
    public int addSecret(Secret secret) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int secretId = (int)session.save(secret);
        transaction.commit();
        return secretId;
    }

    /**
     * delete an secret by secretId
     * @param secretId the secret's secretId
     */
    public void deleteSecret(int secretId) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Secret secret = (Secret) session.get(Secret.class, secretId);
        session.delete(secret);
        transaction.commit();
    }


    /**
     * Update the secret
     * @param secret
     */
    public void updateSecret(Secret secret) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(secret);
        transaction.commit();
    }
}
