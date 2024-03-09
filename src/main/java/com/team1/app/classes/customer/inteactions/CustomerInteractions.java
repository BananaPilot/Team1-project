package com.team1.app.classes.customer.inteactions;

import com.team1.app.classes.customer.Customer;
import com.team1.app.classes.database.DB;
import com.team1.app.classes.in.In;
import com.team1.app.classes.order.interactions.OrderInteractions;

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
            switch (input) {
                case 1 -> customers.add(customerCRUD.createCustomer());
                case 2 -> customerCRUD.listCustomers(customers);
                case 3 -> System.out.println(customerCRUD.getCustomer(customers));
                case 4 -> customerCRUD.updateCustomer(customers);
                case 5 -> customers.remove(customerCRUD.getCustomer(customers));
                case 6 -> orderInteractions.orderHandler(customerCRUD.getCustomer(customers));
                default -> throw new IllegalStateException("Unexpected value: " + input);
            }
        } while (input > 0);
    }
}
