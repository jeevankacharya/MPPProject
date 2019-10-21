package org.mppproject.entity;

public class Item {

    private int itemId;
    private String name;
    private double price;

    public Item(int itemId, String name, double price) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String toString() {
        return "item_id : " + itemId + "  name: " + name + " price : " + price + "\n";
    }
}
