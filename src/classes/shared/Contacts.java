package classes.shared;

import classes.customer.Customer;
import classes.supplier.Supplier;

import java.util.ArrayList;

public class Contacts extends Searchable {
    private String email;
    private String phoneNumber;

    public Contacts(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static OrderPlacer search(ArrayList<? extends Searchable> searchables, Object value) {
        for (Searchable searchable : searchables) {
            if (searchable instanceof Customer customer) {
                if (customer.getContacts().contains(value)) return customer;
            }
            if (searchable instanceof Supplier supplier) {
                if (supplier.getContacts().contains(value)) return supplier;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
