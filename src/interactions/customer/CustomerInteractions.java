package interactions.customer;

import CRUD.customer.CustomerCRUD;
import classes.customer.Customer;
import classes.database.DB;
import in.Input;
import prompts.customer.CustomerPrompts;

import java.util.ArrayList;

public class CustomerInteractions {
    private final ArrayList<Customer> customers = DB.getInstance().getCustomers();
    private final CustomerCRUD customerCRUD = new CustomerCRUD();

    public void CustomerHandler() {
        int input;
        do {
            CustomerPrompts.customerMainPrompt();
            input = Input.getInput();
            switch (input) {
                case 1 -> customers.add(customerCRUD.createCustomer());
                case 2 -> customerCRUD.listCustomers(customers);
                case 3 -> System.out.println(customerCRUD.getCustomer(customers));
                case 4 -> customerCRUD.updateCustomer(customers);
                case 5 -> customers.remove(customerCRUD.getCustomer(customers));
            }
        } while (input != 0);
    }
}
