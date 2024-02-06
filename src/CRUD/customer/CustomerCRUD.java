package CRUD.customer;

import classes.interfaces.Searchable;
import classes.shared.Contacts;
import classes.customer.Customer;
import in.Input;
import interactions.customer.CustomerInteractions;
import prompts.customer.CustomerPrompts;
import util.Util;

import java.util.ArrayList;

public class CustomerCRUD {
  public static Customer createCustomer(){
    return new Customer(Input.getString("Name: "), Input.getString("Surname: "), Input.getString("Address: "), Input.getString("E-Mail: "), Input.getString("Phone-number: "));
  }

  public static void listCustomers(){
    Util.printArrayList(CustomerInteractions.getCustomers());
  }

  public static Customer getCustomer() {
    int input;
    CustomerPrompts.customerSearchPrompt();
    input = Input.getInput();
    Object object = switch (input) {
      case 1 -> Searchable.search(CustomerInteractions.getCustomers(), Input.getString("ID: "));
      case 2 -> Contacts.search(CustomerInteractions.getCustomers(), Input.getString("Email: "));
      case 3 -> Searchable.search(CustomerInteractions.getCustomers(), Input.getString("Name: "), Input.getString("Surname: "));
      default -> null;
    };
    return (Customer) object;
  }

  public static void updateCustomer() {
    Customer customer = getCustomer();
    if (customer == null){
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

//  public static Customer search(ArrayList<Customer> customers, Object... values){
//    for (Customer customer: customers){
//      if (customer.contains(values)) return customer;
//    }
//    return null;
//  }
}
