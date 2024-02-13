package interactions.order;

import CRUD.order.OrderCRUD;
import classes.shared.Operations;
import in.Input;
import prompts.order.OrderPrompts;

public class OrderInteractions {
    OrderCRUD orderCRUD = new OrderCRUD();
    public void orderHandler(Operations operations) {
        int input;
        do {
            OrderPrompts.orderMainPrompt();
            input = Input.getInput();
            switch (input) {
                case 1 -> operations.getOrders().add(orderCRUD.createOrder());
                case 2 -> orderCRUD.listOrders(operations.getOrders());
                case 3 -> System.out.println(orderCRUD.getOrder(operations.getOrders()));
                case 4 -> orderCRUD.updateOrder(operations.getOrders());
                case 5 -> operations.getOrders().remove(orderCRUD.getOrder(operations.getOrders()));
            }
        } while (input != 0);
    }
}
