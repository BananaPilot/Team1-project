package classes.shared;

import classes.interfaces.Searchable;

import java.util.ArrayList;
import java.util.UUID;

public class Placeholder implements Searchable {
    private final String ID;
    private String address;
    private Contacts contacts;
    private ArrayList<Order> orders = new ArrayList<>();

    public Placeholder(String address, String email, String phoneNumber) {
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
        return "Placeholder{" +
                "ID='" + ID + '\'' +
                ", address='" + address + '\'' +
                ", contacts=" + contacts +
                ", orders=" + orders +
                '}';
    }
}
