package classes.customer.inteactions;

import classes.customer.Customer;
import classes.shared.Searchable;
import classes.shared.Contacts;
import in.Input;
import util.Util;

import java.util.ArrayList;

public class CustomerCRUD {
    public Customer createCustomer() {
        return new Customer(Input.getString("Name: "), Input.getString("Surname: "), Input.getString("Address: "), Input.getString("E-Mail: "), Input.getString("Phone-number: "));
    }

    public void listCustomers(ArrayList<Customer> customers) {
        Util.printArrayList(customers);
    }

    public Customer getCustomer(ArrayList<Customer> customers) {
        int input;
        CustomerPrompts.customerSearchPrompt();
        input = Input.getInput();
        return switch (input) {
            case 1 -> Searchable.search(customers, Input.getString("ID: "));
            case 2 -> (Customer) Contacts.search(customers, Input.getString("Email: "));
            case 3 -> Searchable.search(customers, Input.getString("Name: "), Input.getString("Surname: "));
            default -> null;
        };
    }

    public void updateCustomer(ArrayList<Customer> customers) {
        Customer customer = getCustomer(customers);
        if (customer == null) {
            System.out.println("Something went wrong please try again");
            return;
        }
        int input;
        do {
            CustomerPrompts.customerUpdatePrompt();
            input = Input.getInput();
            switch (input) {
                case 1 -> customer.setName(Input.getString("New name: "));
                case 2 -> customer.setSurname(Input.getString("New Surname: "));
                case 3 -> customer.setAddress(Input.getString("New address: "));
                case 4 -> customer.getContacts().setEmail(Input.getString("New E-mail: "));
                case 5 -> customer.getContacts().setEmail(Input.getString("New Phone-number: "));
            }
        } while (input != 0);
        System.out.println("Updated Customer: " + customer);
    }
}
