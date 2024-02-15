package classes.customer;

import classes.interfaces.Searchable;
import classes.shared.Placeholder;

public class Customer extends Placeholder implements Searchable {
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
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                "} " + super.toString();
    }
}
