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
public abstract class User implements Serializable{
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    
    private boolean admin;

    /**
     * Constuctor to construct a non admin user
     * You can also use User(String username, String firstName, String lastName, String password, String phone, boolean admin)
     * constructor however make sure the last parameter admin is set to false.
     * @param username, Username desired.
     * @param firstName, First name
     * @param lastName, Last name
     * @param password, Password(Non Encrypted)
     * @param phone, Phone Number
     */
    public User(String username, String firstName, String lastName, String password, String phone) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.admin = false;
    }

    /**
     * Default constructor
     */
    public User() {}
    
    /**
     * Constructor to construct an admin user
    * @param username, Username desired.
     * @param firstName, First name
     * @param lastName, Last name
     * @param password, Password(Non Encrypted)
     * @param phone, Phone Number
     * @param admin, isAdmin variable: true if user is admin else false for regular user.
     */
    public User(String username, String firstName, String lastName, String password, String phone, boolean admin) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.admin = admin;
    }

    /**
     * This method gets the username for the user.
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method modifies the username for the user.
     * @param username, Username for the user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method gets the First Name for the user.
     * @return firstname
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method modifies the firstname for the user.
     * @param firstName, First Name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * This method gets the lastname for the user.
     * @return lastname
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method modifies the lastname for the user.
     * @param lastName, Last Name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * This method gets the password for the user.
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method modifies the password for the user.
     * @param password, Password(non encrypted password)
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method gets the phone number for the user.
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method modifies the phone for the user.
     * @param phone, Phone Number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * This method tells if the user is admin
     * @return True if yes else false
     */
    public boolean isAdmin() {
        return admin;
    }

    /**
     * This method allows modifing the access level
     * @param admin, Boolean True if admin else false
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", phone=" + phone + ", admin=" + admin + '}';
    }
 
    
}
