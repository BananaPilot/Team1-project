package com.team1.app.classes.order.interactions;

import com.team1.app.classes.product.interactions.ProductCRUD;
import com.team1.app.classes.database.DB;
import com.team1.app.classes.order.Order;
import com.team1.app.classes.shared.OrderProduct;
import com.team1.app.classes.shared.Searchable;
import com.team1.app.classes.in.Input;
import com.team1.app.classes.util.Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderCRUD {
    private final ProductCRUD productCRUD = new ProductCRUD();
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public Order createOrder() {
        ArrayList<OrderProduct> orderProducts = new ArrayList<>();
        int input;
        do{
            OrderPrompts.orderCreationPrompt();
            input = Input.getInstance().getInput();
            switch (input) {
                case 1 -> orderProducts.add(new OrderProduct(Input.getInstance().getInt("Quantity: "), Util.select(DB.getInstance().getProducts(), "Select a product to add")));
                case 2 -> orderProducts.add(new OrderProduct(Input.getInstance().getInt("Quantity: "), productCRUD.createProduct()));
                default -> throw new IllegalStateException("Unexpected value: " + input);
            }
        } while (input > 0);
        if (orderProducts.isEmpty()) return null;
        return new Order(orderProducts);
    }

    public void listOrders(List<Order> orders) {
        Util.printArrayList(orders);
    }

    public Order getOrder(List<Order> orders) {
        OrderPrompts.orderSearchPrompt();
        int input = Input.getInstance().getInput();
        return switch (input) {
            case 1 -> Searchable.search(orders, Input.getInstance().getString("ID: "));
            case 2 -> Searchable.search(orders, LocalDate.parse(Input.getInstance().getString("Date com.team1.app.classes.in format DD-MM-YYYY"), dateFormat));
            default -> throw new IllegalStateException("Unexpected value: " + input);
        };
    }

    public void updateOrder(List<Order> orders) {
        Order order = getOrder(orders);
        if (order == null) return;
        int input;
        do {
            OrderProduct orderProduct = Util.select(order.getProducts(), "Select a product to change");
            OrderPrompts.orderUpdatePrompt();
            input = Input.getInstance().getInput();
            switch (input) {
                case 1 -> orderProduct.setOrderQty(Input.getInstance().getInt("New quantity: "));
                case 2 -> orderProduct.setProduct(Util.select(DB.getInstance().getProducts(), "Select a new product"));
                default -> throw new IllegalStateException("Unexpected value: " + input);
            }
        } while (input > 0);
    }
}