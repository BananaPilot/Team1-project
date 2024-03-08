package com.team1.app.classes.customer;

import com.team1.app.classes.shared.Searchable;
import com.team1.app.classes.shared.OrderPlacer;

public class Customer extends OrderPlacer {
    private String name;
    private String surname;

    public Customer(String name, String surname, String address, String email, String phoneNumber) {
        super(address, email, phoneNumber);
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "-------------------------------" + '\n' +
                "### Customer" + '\n' +
                "-------------------------------" + '\n' +
                "Name: " + name + '\n' +
                "Surname: " + surname + '\n' +
                super.toString() + '\n' +
                "-------------------------------";
    }
}
