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
public class Room {
    private int roomNumber;
    private int packageID;
    private int guests;
    private boolean Fridge;
    private boolean TV;
    private boolean WiFi;
    private double price;

    public Room() {}
    
    public Room(int roomNumber, int packageID, int guests, boolean Fridge, boolean TV, boolean WiFi, double price) {
        this.roomNumber = roomNumber;
        this.packageID = packageID;
        this.guests = guests;
        this.Fridge = Fridge;
        this.TV = TV;
        this.WiFi = WiFi;
        this.price = price;
    }

    public Room(int packageID, int guests, boolean Fridge, boolean TV, boolean WiFi, double price) {
        this.packageID = packageID;
        this.guests = guests;
        this.Fridge = Fridge;
        this.TV = TV;
        this.WiFi = WiFi;
        this.price = price;
        this.roomNumber = 0;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public boolean isFridge() {
        return Fridge;
    }

    public void setFridge(boolean Fridge) {
        this.Fridge = Fridge;
    }

    public boolean isTV() {
        return TV;
    }

    public void setTV(boolean TV) {
        this.TV = TV;
    }

    public boolean isWiFi() {
        return WiFi;
    }

    public void setWiFi(boolean WiFi) {
        this.WiFi = WiFi;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" + "roomNumber=" + roomNumber + ", packageID=" + packageID + ", guests=" + guests + ", Fridge=" + Fridge + ", TV=" + TV + ", WiFi=" + WiFi + ", price=" + price + '}';
    }

    
}
