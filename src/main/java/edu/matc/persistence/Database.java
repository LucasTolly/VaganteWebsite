package edu.matc.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 * Gets access to the VaganteScholar database
 * @author Lucas Tolly
 */

public class Database {

    private final Logger logger = Logger.getLogger(this.getClass());
    private static Database instance = new Database();
    private Properties properties;
    private Connection connection;
    private Database() {
        loadProperties();
    }

    /**
     * Getter for Instance
     * @return
     */
    public static Database getInstance() {
        return instance;
    }

    /**
     * Getter for Connection
     * @return
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * This method loads the set properties that contains the
     * MySQL Database's credentials
     */
    private void loadProperties() {
        properties = new Properties();
        try {
            properties.load (this.getClass().getResourceAsStream("/database.properties"));
        } catch (IOException ioe) {
            logger.error(ioe.getStackTrace());
        } catch (Exception e) {
            logger.error(e.getStackTrace());
        }

    }

    /**
     * Creates a connection to the desired database
     * @throws Exception
     */
    public void connect() throws Exception {
        if (connection != null)
            return;

        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            logger.error(e.getStackTrace());
            throw new Exception("Database.connect()... Error: MySQL Driver not found");
        }

        String url = properties.getProperty("url");
        connection = DriverManager.getConnection(url, properties.getProperty("username"),  properties.getProperty("password"));
    }

    /**
     * Disconnects from the database
     */
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getStackTrace());
            }
        }

        connection = null;
    }

}