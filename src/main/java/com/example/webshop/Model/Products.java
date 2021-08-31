package com.example.webshop.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Products {

    @Id
    private int productID;
    private String name;
    private double price;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "Product id:" + productID + "\nName: " + name + "\nPrice: " + price;
    }
}
