package com.team1.app.classes.shared;

import com.team1.app.classes.customer.Customer;
import com.team1.app.classes.supplier.Supplier;

import java.util.List;

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

    @Override
    public String toString() {
        return  "E-mail: " + email + " - " +
                "Phone Number: " + phoneNumber;
    }
}
