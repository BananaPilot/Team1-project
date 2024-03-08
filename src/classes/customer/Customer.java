package classes.customer;

import classes.shared.Searchable;
import classes.shared.OrderPlacer;

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
<<<<<<< Updated upstream:src/classes/customer/Customer.java
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                "} " + super.toString();
=======
        return "-------------------------------" + '\n' +
                "### Customer" + '\n' +
                "-------------------------------" + '\n' +
                "Name: " + name + '\n' +
                "Surname: " + surname + '\n' +
                super.toString() + '\n' +
                "-------------------------------";
>>>>>>> Stashed changes:src/main/java/com/team1/app/classes/customer/Customer.java
    }
}
