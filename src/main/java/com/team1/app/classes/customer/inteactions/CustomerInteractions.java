package com.team1.app.classes.customer.inteactions;

import com.team1.app.classes.customer.Customer;
import com.team1.app.classes.database.DB;
import com.team1.app.classes.in.In;
import com.team1.app.classes.order.interactions.OrderInteractions;
import com.team1.app.classes.shared.ExceptionHandler;

import java.util.List;

public class CustomerInteractions {
    private final List<Customer> customers = DB.getInstance().getCustomers();
    private final CustomerCRUD customerCRUD = new CustomerCRUD();
    private final OrderInteractions orderInteractions = new OrderInteractions();

    public void customerHandler() {
        int input;

        do {
            CustomerPrompts.customerMainPrompt();
            input = In.getInstance().getInput();
            try {
                switch (input) {
                    case 1 -> customers.add(customerCRUD.createCustomer());
                    case 2 -> customerCRUD.listCustomers(customers);
                    case 3 -> System.out.println(customerCRUD.getCustomer(customers));
                    case 4 -> customerCRUD.updateCustomer(customers);
                    case 5 -> customers.remove(customerCRUD.getCustomer(customers));
                    case 6 -> orderInteractions.orderHandler(customerCRUD.getCustomer(customers));
                    case 0 -> System.out.println("Going back");
                    default -> System.out.println("Unexpected value: " + input);
                }
            } catch (Exception e) {
                new ExceptionHandler().handle(e);
            }
        } while (input != 0);

    }
}
