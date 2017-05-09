package edu.matc.persistence;

import edu.matc.entity.UserRoles;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * This class test all methods in UserRolesDao
 * @author tolly
 */
public class UserRolesDaoTest {

    public static UserRolesDao userRolesDao = new UserRolesDao();

    @Test public void addUserRole() {
        UserRoles userRoles = new UserRoles();
        userRoles.setUsername("TestName");
        userRoles.setRoleName("TestRole");

        userRolesDao.addUserRoles(userRoles);

        UserRoles insertedUserRole = userRolesDao.getUserRole("TestName");
        assertEquals(insertedUserRole.getRoleName(), "TestRole");
    }


    @AfterClass public static void deleteTestUsers() {

        userRolesDao.deleteUser("TestName");
    }
}
