package interactions.customer;

import CRUD.customer.CustomerCRUD;
import classes.customer.Customer;
import classes.database.DB;
import in.Input;
import prompts.customer.CustomerPrompts;
import database.DB;

public class CustomerInteractions {
  CustomerCRUD customerCRUD = new CustomerCRUD();
  public void CustomerHandler(){
    int input;
    do {
      CustomerPrompts.customerMainPrompt();
      input = Input.getInput();
      switch (input) {
        case 1 -> DB.getCustomers().add(customerCRUD.createCustomer());
        case 2 -> customerCRUD.listCustomers();
        case 3 -> System.out.println(customerCRUD.getCustomer());
        case 4 -> customerCRUD.updateCustomer();
        case 5 -> DB.getCustomers().remove(customerCRUD.getCustomer());
      }
    } while(input != 0);
  }
}
