package interactions.customer;

import CRUD.customer.CustomerCRUD;
import in.Input;
import prompts.customer.CustomerPrompts;
import database.DB;

public class CustomerInteractions {

  public static void CustomerHandler(){
    int input;
    do {
      CustomerPrompts.customerMainPrompt();
      input = Input.getInput();
      switch (input) {
        case 1 -> DB.getCustomers().add(CustomerCRUD.createCustomer());
        case 2 -> CustomerCRUD.listCustomers();
        case 3 -> System.out.println(CustomerCRUD.getCustomer());
        case 4 -> CustomerCRUD.updateCustomer();
        case 5 -> DB.getCustomers().remove(CustomerCRUD.getCustomer());
      }
    } while(input != 0);
  }
}
