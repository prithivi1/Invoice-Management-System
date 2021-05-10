package com.company;

import java.util.List;

public class Invoice {
    String customerName;
    List<Products> items;
    int total;

//    Invoice obj{
//        customer name:prithivi
//        list
//        0 1 2
//        obj obj obj
//        pen pencil bag
//        2 5 1
//        20 50 200
//
//
//        total:
//        270
//    }
//
//    name : prithivi


    public Invoice(String customerName, List<Products> items, int total) {
        this.customerName = customerName;
        this.items = items;
        this.total = total;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Products> getItems() {
        return items;
    }

    public void setItems(List<Products> items) {
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
