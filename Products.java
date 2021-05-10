package com.company;

public class Products {
    String name;
    int cost;
    int quantity;

    public Products(String item, int cost) {
        this.name = item;
        this.cost = cost;
    }

    public Products(String item, int cost,int quantity) {
        this.name = item;
        this.cost = cost;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
