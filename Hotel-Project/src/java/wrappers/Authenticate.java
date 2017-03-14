/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrappers;

import java.io.Serializable;

/**
 *
 * @author Anirudh
 */
public class Authenticate implements Serializable{

    /**
     * Authentication username
     */
    public String username;

    /**
     * Authentication password 
     */
    public String password;

    /**
     * Default Constructor for Spring MVC to use
     */
    public Authenticate() {}

    /**
     * Constructor for us to create an authentication object.
     * @param username, Username provided for authentication
     * @param password, Password provided for authentication
     */
    public Authenticate(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * This Method gets the current username from this authentication object.
     * @return username from this current object model
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method provides the ability to update the username for current authentication object.
     * @param username, new username to replace the old one.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This Method gets the current password from this authentication object.
     * @return password for the username.
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method provides the ability to update the password for current authentication object.
     * @param password password for the new authentication model
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Authenticate{" + "username=" + username + ", password=" + password + '}';
    }
    
}
