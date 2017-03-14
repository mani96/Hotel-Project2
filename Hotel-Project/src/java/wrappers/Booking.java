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
public class Booking {
    private int booking_id;
    private String username;
    private int room_number;
    private String start_date;
    private String end_date;
    private String special_notes;

    public Booking(String username, int room_number, String start_date, String end_date, String special_notes) {
        this.booking_id = -99;
        this.username = username;
        this.room_number = room_number;
        this.start_date = start_date;
        this.end_date = end_date;
        this.special_notes = special_notes;
    }

    public Booking() {
    }
    
    public Booking(String username, int room_number, String start_date, String end_date) {
        this.booking_id = -99;
        this.special_notes = "No Special Request!";
        this.username = username;
        this.room_number = room_number;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        this.booking_id = booking_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getSpecial_notes() {
        return special_notes;
    }

    public void setSpecial_notes(String special_notes) {
        this.special_notes = special_notes;
    }

    @Override
    public String toString() {
        return "Booking{" + "booking_id=" + booking_id + ", username=" + username + ", room_number=" + room_number + ", start_date=" + start_date + ", end_date=" + end_date + ", special_notes=" + special_notes + '}';
    }

    
}
