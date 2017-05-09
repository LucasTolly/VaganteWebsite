package edu.matc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A class to represent a user.
 *
 * @author Lucas Tolly
 * Created: 2/6/2017
 */
@Entity
@Table(name = "user_roles")
public class UserRoles {

    @Id
    @Column(name = "user_name")
    private String username;

    @Column(name = "role_name")
    private String roleName;

    /**
     * Empty constructor
     */
    public UserRoles() {

    }

    /**
     * Constructor that takes in two parameters to set a UserRole's
     * instance variables.
     * @param username
     * @param roleName
     */
    public UserRoles(String username, String roleName) {
        this.username = username;
        this.roleName = roleName;
    }

    /**
     * Getter for username
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter for username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter for roleName
     * @return
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Setter for roleName
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
