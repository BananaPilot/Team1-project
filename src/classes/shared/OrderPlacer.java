package classes.shared;

import classes.order.Order;
import util.Util;

import java.util.ArrayList;
import java.util.UUID;

public abstract class OrderPlacer extends Searchable {
    private final String ID;
    private String address;
    private Contacts contacts;
    private ArrayList<Order> orders = new ArrayList<>();

    public OrderPlacer(String address, String email, String phoneNumber) {
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

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return  "ID: " + ID + '\n' +
                "address: " + address + '\n' +
                "contacts: " + contacts + '\n' +
                "orders: " + Util.splitter(orders) + "\n";
    }
}
