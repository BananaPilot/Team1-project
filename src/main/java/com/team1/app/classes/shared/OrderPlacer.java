package com.team1.app.classes.shared;

import com.team1.app.classes.order.Order;
import com.team1.app.classes.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class OrderPlacer extends Searchable {
    private final String ID;
    private String address;
    private Contacts contacts;
    private List<Order> orders = new ArrayList<>();

    protected OrderPlacer(String address, String email, String phoneNumber) {
        this.ID = UUID.randomUUID().toString();
        this.address = address;
        this.contacts = new Contacts(email, phoneNumber);
    }

    private double getTotal() {
        double total = 0;
        for (Order order: orders){
            total += order.getTotal();
        }
        return total;
    }

    public String getID() {
        return ID;
    }

    public String getAddress() {
        return address;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return  "ID: " + ID + '\n' +
                "Address: " + address + '\n' +
                "Contact Information: " + '\n' + contacts + '\n' +
                "Orders: " + '\n' + Util.splitter(orders);
    }
}
