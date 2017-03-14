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
public class Availability {
    public String checkin;
    public String checkout;
    public String guest;

    public Availability(String checkin, String checkout, String guest) {
        this.checkin = checkin;
        this.checkout = checkout;
        this.guest = guest;
    }
    
  
}
