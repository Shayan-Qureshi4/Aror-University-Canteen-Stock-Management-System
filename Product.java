/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private int stock;
    private int min_stock;

    public Product(int id, String name, String category, double price, int stock, int min_stock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.min_stock = min_stock;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    public int getMinStock() { return min_stock; }
    public void setStock(int s) { this.stock = s; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + category + " | $" + price + " | Stock: " + stock;
    }
}
