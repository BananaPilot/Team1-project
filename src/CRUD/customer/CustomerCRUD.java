package CRUD.customer;

import classes.database.DB;
import classes.interfaces.Searchable;
import classes.shared.Contacts;
import classes.customer.Customer;
import database.DB;
import in.Input;
import interactions.customer.CustomerInteractions;
import prompts.customer.CustomerPrompts;
import util.Util;

import java.util.ArrayList;

public class CustomerCRUD {
  private ArrayList<Customer> customers = DB.getCustomers();

  public Customer createCustomer(){
    return new Customer(Input.getString("Name: "), Input.getString("Surname: "), Input.getString("Address: "), Input.getString("E-Mail: "), Input.getString("Phone-number: "));
  }

  public void listCustomers(){
    Util.printArrayList(customers);
  }

  public  Customer getCustomer() {
    int input;
    CustomerPrompts.customerSearchPrompt();
    input = Input.getInput();
    Object object = switch (input) {
      case 1 -> Searchable.search(customers, Input.getString("ID: "));
      case 2 -> Contacts.search(customers, Input.getString("Email: "));
      case 3 -> Searchable.search(customers, Input.getString("Name: "), Input.getString("Surname: "));
      default -> null;
    };
    return (Customer) object;
  }

  public void updateCustomer() {
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
}
