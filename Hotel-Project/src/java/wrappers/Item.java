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
public class Item implements Serializable {

    /**
     * ID for the food
     */
    public int id;

    /**
     * Name for the food
     */
    public String name;

    /**
     * Description for food
     */
    public String description;

    /**
     * Price for food
     */
    public double price;

    /**
     * Number of people served
     */
    public int serves;

    /**
     * 
     */
    public int quanity;    
            
    /**
     * Default 
     */
    public Item() {
        this.quanity = 1;
    }

    /**
     * Constructor for new food
     * @param id
     * @param name
     * @param description
     * @param price
     * @param serves
     */
    public Item(int id, String name, String description, double price, int serves) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.serves = serves;
        this.quanity = 1;
    }
    
    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity)
    {
        this.quanity = quantity;
    }

    /**
     *
     * @return
     */
    public int getQuanity() {
        return quanity;
    }
    
    /**
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    public int getServes() {
        return serves;
    }

    /**
     *
     * @param serves
     */
    public void setServes(int serves) {
        this.serves = serves;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", serves=" + serves + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        } else {
            Item i = (Item) obj;
            return i.getName().equalsIgnoreCase(this.getName());
        }
    }

}
