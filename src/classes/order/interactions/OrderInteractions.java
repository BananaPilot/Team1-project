package classes.order.interactions;

import classes.shared.OrderPlacer;
import in.Input;

public class OrderInteractions {
    private final OrderCRUD orderCRUD = new OrderCRUD();

    public void orderHandler(OrderPlacer orderPlacer) {

        int input;
        do {
            OrderPrompts.orderMainPrompt();
            input = Input.getInstance().getInput();
            switch (input) {
                case 1 -> orderPlacer.getOrders().add(orderCRUD.createOrder());
                case 2 -> orderCRUD.listOrders(orderPlacer.getOrders());
                case 3 -> System.out.println(orderCRUD.getOrder(orderPlacer.getOrders()));
                case 4 -> orderCRUD.updateOrder(orderPlacer.getOrders());
                case 5 -> orderPlacer.getOrders().remove(orderCRUD.getOrder(orderPlacer.getOrders()));
            }
        } while (input != 0);
    }
}
