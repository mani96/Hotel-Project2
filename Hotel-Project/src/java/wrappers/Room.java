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
public class Room implements Serializable{
    private int roomNumber;
    private int packageID;
    private int guests;
    private boolean Fridge;
    private boolean TV;
    private boolean WiFi;
    private double price;

    /**
     * Default Constructor
     */
    public Room() {}
    
    /**
     * Constructor if you know the roomNumber you want to give to the new room.
     * @param roomNumber, Room Number
     * @param packageID, Package ID
     * @param guests, Number of guest or beds
     * @param Fridge, Fridge Available
     * @param TV, TV Available
     * @param WiFi, WiFi Available
     * @param price, Price
     */
    public Room(int roomNumber, int packageID, int guests, boolean Fridge, boolean TV, boolean WiFi, double price) {
        this.roomNumber = roomNumber;
        this.packageID = packageID;
        this.guests = guests;
        this.Fridge = Fridge;
        this.TV = TV;
        this.WiFi = WiFi;
        this.price = price;
    }

    /**
     * Constructor if you don't want to give any room number but want to automatically generate one.
     * @param packageID
     * @param guests
     * @param Fridge
     * @param TV
     * @param WiFi
     * @param price
     */
    public Room(int packageID, int guests, boolean Fridge, boolean TV, boolean WiFi, double price) {
        this.packageID = packageID;
        this.guests = guests;
        this.Fridge = Fridge;
        this.TV = TV;
        this.WiFi = WiFi;
        this.price = price;
        this.roomNumber = 0;
    }

    /**
     * This method gets the room number
     * @return roomNumber
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * This method sets the room number
     * @param roomNumber
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * This method gets the package id
     * @return packageID
     */
    public int getPackageID() {
        return packageID;
    }

    /**
     * This method sets the package id
     * @param packageID, Package ID
     */
    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    /**
     * This method gets the number of beds
     * @return guests
     */
    public int getGuests() {
        return guests;
    }

    /**
     * This method sets the guests
     * @param guests
     */
    public void setGuests(int guests) {
        this.guests = guests;
    }

    /**
     * This method gets the availablity of fridge
     * @return boolean
     */
    public boolean isFridge() {
        return Fridge;
    }

    /**
     * This method sets the availablity of fridge
     * @param Fridge, Boolean
     */
    public void setFridge(boolean Fridge) {
        this.Fridge = Fridge;
    }

    /**
     * This method gets the availablity of TV
     * @return boolean
     */
    public boolean isTV() {
        return TV;
    }

    /**
     * This method sets the availablity of TV
     * @param TV, Boolean
     */
    public void setTV(boolean TV) {
        this.TV = TV;
    }

    /**
     * This method gets the availablity of WiFi
     * @return Boolean
     */
    public boolean isWiFi() {
        return WiFi;
    }

    /**
     * This method sets the availablity of WiFi
     * @param WiFi, Boolean
     */
    public void setWiFi(boolean WiFi) {
        this.WiFi = WiFi;
    }

    /**
     * This method gets the price
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * This method sets the price
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" + "roomNumber=" + roomNumber + ", packageID=" + packageID + ", guests=" + guests + ", Fridge=" + Fridge + ", TV=" + TV + ", WiFi=" + WiFi + ", price=" + price + '}';
    }

    
}
