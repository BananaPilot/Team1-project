package interactions.customer;

import CRUD.customer.CustomerCRUD;
import classes.customer.Customer;
import in.Input;
import prompts.customer.CustomerPrompts;

import java.util.ArrayList;

public class CustomerInteractions {
  private static ArrayList<Customer> customers;

  public static ArrayList<Customer> getCustomers(){
    if (customers == null){
      customers = new ArrayList<>();
    }
    return customers;
  }

  public static void CustomerHandler(){
    int input;
    do {
      CustomerPrompts.customerMainPrompt();
      input = Input.getInt();
      switch (input) {
        case 1 -> getCustomers().add(CustomerCRUD.createCustomer());
        case 2 -> CustomerCRUD.listCustomers();
        case 3 -> System.out.println(CustomerCRUD.getCustomer());
        case 4 -> CustomerCRUD.updateCustomer();
        case 5 -> getCustomers().remove(CustomerCRUD.getCustomer());
      }
    } while(input != 0);
  }
}
