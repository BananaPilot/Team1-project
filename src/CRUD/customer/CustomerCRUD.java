package CRUD.customer;

import classes.customer.Customer;
import classes.in.Input;
import interactions.customer.CustomerInteractions;
import prompts.customer.CustomerPrompts;

public class CustomerCRUD {
  public static Customer createCustomer(){
    return new Customer(Input.getString("Name: "), Input.getString("Surname: "), Input.getString("Address: "), Input.getString("E-Mail: "), Input.getString("Phone-number: "));
  }

  public static void listCustomers(){
    for(Customer customer : CustomerInteractions.getCustomers()){
      System.out.println(customer);
    }
  }

  public static Customer getCustomer() {
    int input;
    CustomerPrompts.customerSearchPrompt();
    input = Input.getInt();
    return switch (input) {
      case 1 -> SearchCustomer.getCustomerByID(Input.getString("ID: "));
      case 2 -> SearchCustomer.getCustomerByEmail(Input.getString("E-mail: "));
      case 3 -> SearchCustomer.getCustomerByNameSurname(Input.getString("Name: "), Input.getString("Surname"));
      default -> null;
    };
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
      input = Input.getInt();
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
