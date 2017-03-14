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
public class Booking implements Serializable{
    private int booking_id;
    private String username;
    private int room_number;
    private String start_date;
    private String end_date;
    private String special_notes;

    /**
     * Constructor
     * @param username, Username for the person who holds the booking
     * @param room_number, Room number for the booking
     * @param start_date, Start Date for the booking
     * @param end_date, End Date for the booking
     * @param special_notes, Special notes for the booking
     */
    public Booking(String username, int room_number, String start_date, String end_date, String special_notes) {
        this.booking_id = -99;
        this.username = username;
        this.room_number = room_number;
        this.start_date = start_date;
        this.end_date = end_date;
        this.special_notes = special_notes;
    }

    /**
     * Default Constructor
     */
    public Booking() {}
    
    /**
     * Constructor
     * @param username, Username for the user who holds the booking
     * @param room_number, Room Number for the booking
     * @param start_date, Start Date for the booking
     * @param end_date, End Date for the booking
     */
    public Booking(String username, int room_number, String start_date, String end_date) {
        this.booking_id = -99;
        this.special_notes = "No Special Request!";
        this.username = username;
        this.room_number = room_number;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    /**
     * This method gets the booking id for the booking.
     * @return booking_id
     */
    public int getBooking_id() {
        return booking_id;
    }

    /**
     * This method modifies the booking id.
     * @param booking_id, Booking ID
     */
    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    /**
     * This method gets the username associated with the booking.
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method allows changing the username registered with the booking!
     * This method will barely be used because it is out of context
     * @param username, new username required.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method gets the room number associated with the booking.
     * @return the room number
     */
    public int getRoom_number() {
        return room_number;
    }

    /**
     * This method changes the room number of the booking.
     * @param room_number, room number
     */
    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    /**
     * This method gets the start date of the booking.
     * @return the start date of the booking
     */
    public String getStart_date() {
        return start_date;
    }

    /**
     * This method changes the start date of the booking.
     * @param start_date
     */
    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    /**
     * This method gets the end date of the booking.
     * @return the end date
     */
    public String getEnd_date() {
        return end_date;
    }

    /**
     * This method sets the end date of the booking
     * @param end_date, the end date
     */
    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    /**
     * This method gets any special notes left by the customer.
     * @return special_notes left!
     */
    public String getSpecial_notes() {
        return special_notes;
    }

    /**
     * This method allows the modification of the special notes
     * @param special_notes, Special Notes
     */
    public void setSpecial_notes(String special_notes) {
        this.special_notes = special_notes;
    }

    @Override
    public String toString() {
        return "Booking{" + "booking_id=" + booking_id + ", username=" + username + ", room_number=" + room_number + ", start_date=" + start_date + ", end_date=" + end_date + ", special_notes=" + special_notes + '}';
    }

    
}
