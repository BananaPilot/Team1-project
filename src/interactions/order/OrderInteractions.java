package interactions.order;

import CRUD.order.OrderCRUD;
import classes.shared.Placeholder;
import in.Input;
import prompts.order.OrderPrompts;

public class OrderInteractions {
    private final OrderCRUD orderCRUD = new OrderCRUD();

    public void orderHandler(Placeholder placeholder) {

        int input;
        do {
            OrderPrompts.orderMainPrompt();
            input = Input.getInput();
            switch (input) {
                case 1 -> placeholder.getOrders().add(orderCRUD.createOrder());
                case 2 -> orderCRUD.listOrders(placeholder.getOrders());
                case 3 -> System.out.println(orderCRUD.getOrder(placeholder.getOrders()));
                case 4 -> orderCRUD.updateOrder(placeholder.getOrders());
                case 5 -> placeholder.getOrders().remove(orderCRUD.getOrder(placeholder.getOrders()));
            }
        } while (input != 0);
    }
}
