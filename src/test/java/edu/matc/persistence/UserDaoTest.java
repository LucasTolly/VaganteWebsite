package edu.matc.persistence;

import org.apache.log4j.Logger;
import edu.matc.persistence.UserDao;
import edu.matc.entity.*;
import java.util.List;
import java.util.ArrayList;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

/**
 * This class test all methods in UserDao
 * @author tolly
 */
public class UserDaoTest {

    public static UserDao userDao = new UserDao();

    @BeforeClass
    public static void setup() {
        userDao = new UserDao();
        User newUser = new User();
        newUser.setUsername("TestTestTest");
        newUser.setPassword("TestPassword");
        String username = userDao.addUser(newUser);
    }

    @Test public void getAllUsers() throws Exception {
        List<User> users = userDao.getAllUsers();

        User insertedUser = new User();
        insertedUser.setUsername("Bad");


        for (User user : users) {
            if (user.getPassword().equals("TestPassword")) {
                insertedUser = user;
            }
        }

        assertEquals("TestTestTest", insertedUser.getUsername());
    }

    @Test public void updateUser() throws Exception {
        List<User> users = userDao.getAllUsers();
        User userToBeUpdated;
        for (User user : users) {
            if (user.getUsername().equals("TestTestTest")) {
                userToBeUpdated = user;
                userToBeUpdated.setPassword("Changing");
                userDao.updateUser(userToBeUpdated);
            }
        }
        List<User> updatedUsers = userDao.getAllUsers();
        User updatedUser;
        Boolean updatedUserFound = false;
        for (User user : updatedUsers) {
            if (user.getPassword().equals("Changing")) {
                updatedUserFound = true;
            }
        }
        assert(updatedUserFound);
    }

    @Test public void getUser() throws Exception {
        List<User> users = userDao.getAllUsers();
        String username = "TestTestTest";

        User user = userDao.getUser(username);
        assertEquals(user.getUsername(), "TestTestTest");
    }

    @AfterClass public static void deleteTestUsers() {
        List<User> users = userDao.getAllUsers();
        for (User user : users) {
            if (user.getUsername().equals("TestTestTest")) {
                userDao.deleteUser(user.getUsername());
            }
        }
    }
}
