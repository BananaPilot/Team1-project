package com.team1.app.classes.customer.inteactions;

import com.team1.app.classes.customer.Customer;
import com.team1.app.classes.shared.Searchable;
import com.team1.app.classes.shared.Contacts;
import com.team1.app.classes.in.In;
import com.team1.app.classes.util.Util;

import java.util.List;

public class CustomerCRUD {
    public Customer createCustomer() {
        return new Customer(In.getInstance().getString("Name: "), In.getInstance().getString("Surname: "), In.getInstance().getString("Address: "), In.getInstance().getString("E-Mail: "), In.getInstance().getString("Phone-number: "));
    }

    public void listCustomers(List<Customer> customers) {
        Util.printArrayList(customers);
    }

    public Customer getCustomer(List<Customer> customers) {
        CustomerPrompts.customerSearchPrompt();
        int input = In.getInstance().getInput();
        return switch (input) {
            case 1 -> Searchable.search(customers, In.getInstance().getString("ID: "));
            case 2 -> (Customer) Contacts.searchByContacts(customers, In.getInstance().getString("Email: "));
            case 3 -> Searchable.search(customers, In.getInstance().getString("Name: "), In.getInstance().getString("Surname: "));
            case 0 -> throw new IllegalArgumentException();
            default -> null;
        };
    }

    public void updateCustomer(List<Customer> customers) {
        Customer customer;
        customer = getCustomer(customers);
        if (customer == null) {
            System.out.println("Something went wrong please try again");
            return;
        }
        int input;
        do {
            CustomerPrompts.customerUpdatePrompt();
            input = In.getInstance().getInput();
            switch (input) {
                case 1 -> customer.setName(In.getInstance().getString("New name: "));
                case 2 -> customer.setSurname(In.getInstance().getString("New Surname: "));
                case 3 -> customer.setAddress(In.getInstance().getString("New address: "));
                case 4 -> customer.getContacts().setEmail(In.getInstance().getString("New E-mail: "));
                case 5 -> customer.getContacts().setPhoneNumber(In.getInstance().getString("New Phone-number: "));
                case 0 -> System.out.println("Going back");
                default -> System.out.println("Unexpected value: " + input);
            }
        } while (input != 0);
        System.out.println("Updated Customer: " + customer);
    }
}
