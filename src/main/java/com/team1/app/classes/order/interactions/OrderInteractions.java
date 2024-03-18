package com.team1.app.classes.order.interactions;

import com.team1.app.classes.shared.ExceptionHandler;
import com.team1.app.classes.shared.OrderPlacer;
import com.team1.app.classes.in.In;

public class OrderInteractions {
    private final OrderCRUD orderCRUD = new OrderCRUD();

    public void orderHandler(OrderPlacer orderPlacer) {
        int input;

        do {
            OrderPrompts.orderMainPrompt();
            input = In.getInstance().getInput();
            try {
                switch (input) {
                    case 1 -> orderPlacer.getOrders().add(orderCRUD.createOrder());
                    case 2 -> orderCRUD.listOrders(orderPlacer.getOrders());
                    case 3 -> System.out.println(orderCRUD.getOrder(orderPlacer.getOrders()));
                    case 4 -> orderCRUD.updateOrder(orderPlacer.getOrders());
                    case 5 -> orderPlacer.getOrders().remove(orderCRUD.getOrder(orderPlacer.getOrders()));
                    case 0 -> System.out.println("Going back");
                    default -> System.out.println("Unexpected value: " + input);
                }
            } catch (Exception e) {
                new ExceptionHandler().handle(e);
            }
        } while (input != 0);

    }
}
