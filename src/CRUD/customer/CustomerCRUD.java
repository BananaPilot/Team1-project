package CRUD.customer;

import classes.shared.Contacts;
import classes.customer.Customer;
import database.DB;
import in.Input;
import interactions.customer.CustomerInteractions;
import prompts.customer.CustomerPrompts;

import java.util.ArrayList;

public class CustomerCRUD {
    public static Customer createCustomer() {
        return new Customer(Input.getString("Name: "), Input.getString("Surname: "), Input.getString("Address: "), Input.getString("E-Mail: "), Input.getString("Phone-number: "));
    }

    public static void listCustomers() {
        for (Customer customer : DB.getCustomers()) {
            System.out.println(customer);
        }
    }

    public static Customer getCustomer() {
        int input;
        CustomerPrompts.customerSearchPrompt();
        input = Input.getInput();
        Object object = switch (input) {
            case 1 -> search(DB.getCustomers(), Input.getString("ID: "));
            case 2 -> Contacts.search(DB.getCustomers(), Input.getString("Email: "));
            case 3 -> search(DB.getCustomers(), Input.getString("Name: "), Input.getString("Surname: "));
            default -> null;
        };
        return (Customer) object;
    }

    public static void updateCustomer() {
        Customer customer = getCustomer();
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

    public static Customer search(ArrayList<Customer> customers, Object... valueToSearch) {
        for (Customer customer : customers) {
            if (customer.contains(valueToSearch)) return customer;
        }
        return null;
    }
}
