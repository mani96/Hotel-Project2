/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrappers;

/**
 *
 * @author Anirudh
 */
public class Client extends User{
    
    public Client() {
        super();
    }
    
    public Client(String username, String firstName, String lastName, String password, String phone)
    {
        super(username,firstName,lastName,password,phone,false);
    }
    
}
