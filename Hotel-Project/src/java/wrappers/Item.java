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

    public int id;
    public String name;
    public String description;
    public double price;
    public int serves;
    public int quanity;    
            
    public Item() {
        this.quanity = 1;
    }

    public Item(int id, String name, String description, double price, int serves) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.serves = serves;
        this.quanity = 1;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity)
    {
        this.quanity = quantity;
    }

    public int getQuanity() {
        return quanity;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }

    public int getServes() {
        return serves;
    }

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
