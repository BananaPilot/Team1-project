package CRUD.customer;

import classes.SearchBy;
import classes.Searchable;
import classes.customer.Customer;
import classes.in.Input;
import interactions.customer.CustomerInteractions;
import prompts.customer.CustomerPrompts;
import util.Util;

public class CustomerCRUD {
  public static Customer createCustomer(){
    return new Customer(Input.getString("Name: "), Input.getString("Surname: "), Input.getString("Address: "), Input.getString("E-Mail: "), Input.getString("Phone-number: "));
  }

  public static void listCustomers(){
    for(Searchable customer : CustomerInteractions.getCustomers()){
      System.out.println(customer);
    }
  }

  public static Customer getCustomer() {
    int input;
    CustomerPrompts.customerSearchPrompt();
    input = Input.getInt();
    Searchable customer = switch (input) {
      case 1 -> Util.search(CustomerInteractions.getCustomers(), SearchBy.ID, Input.getString("ID: "));
      case 2 -> Util.search(CustomerInteractions.getCustomers(), SearchBy.EMAIL, Input.getString("E-mail: "));
      case 3 -> Util.search(CustomerInteractions.getCustomers(), SearchBy.FULL_NAME, Input.getString("Name: "), Input.getString("Surname: "));
      default -> null;
    };
    return (Customer) customer;
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
