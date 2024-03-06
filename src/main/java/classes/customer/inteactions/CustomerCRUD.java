package classes.customer.inteactions;

import classes.customer.Customer;
import classes.shared.Searchable;
import classes.shared.Contacts;
import in.Input;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class CustomerCRUD {
    public Customer createCustomer() {
        return new Customer(Input.getInstance().getString("Name: "), Input.getInstance().getString("Surname: "), Input.getInstance().getString("Address: "), Input.getInstance().getString("E-Mail: "), Input.getInstance().getString("Phone-number: "));
    }

    public void listCustomers(List<Customer> customers) {
        Util.printArrayList(customers);
    }

    public Customer getCustomer(List<Customer> customers) {
        CustomerPrompts.customerSearchPrompt();
        int input = Input.getInstance().getInput();
        return switch (input) {
            case 1 -> Searchable.search(customers, Input.getInstance().getString("ID: "));
            case 2 -> Contacts.search(customers, Input.getInstance().getString("Email: "));
            case 3 -> Searchable.search(customers, Input.getInstance().getString("Name: "), Input.getInstance().getString("Surname: "));
            default -> throw new IllegalStateException("Unexpected value: " + input);
        };
    }

    public void updateCustomer(List<Customer> customers) {
        Customer customer = getCustomer(customers);
        if (customer == null) {
            System.out.println("Something went wrong please try again");
            return;
        }
        int input;
        do {
            CustomerPrompts.customerUpdatePrompt();
            input = Input.getInstance().getInput();
            switch (input) {
                case 1 -> customer.setName(Input.getInstance().getString("New name: "));
                case 2 -> customer.setSurname(Input.getInstance().getString("New Surname: "));
                case 3 -> customer.setAddress(Input.getInstance().getString("New address: "));
                case 4 -> customer.getContacts().setEmail(Input.getInstance().getString("New E-mail: "));
                case 5 -> customer.getContacts().setEmail(Input.getInstance().getString("New Phone-number: "));
                default -> throw new IllegalStateException("Unexpected value: " + input);
            }
        } while (input > 0);
        System.out.println("Updated Customer: " + customer);
    }
}
