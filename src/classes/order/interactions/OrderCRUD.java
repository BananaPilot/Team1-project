package classes.order.interactions;

import classes.product.interactions.ProductCRUD;
import classes.database.DB;
import classes.product.Product;
import classes.order.Order;
import classes.shared.OrderProduct;
import classes.shared.Searchable;
import in.Input;
import util.Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class OrderCRUD {
    private final ProductCRUD productCRUD = new ProductCRUD();
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public Order createOrder() {
        ArrayList<OrderProduct> orderProducts = new ArrayList<>();
        int input;
        do{
            OrderPrompts.orderCreationPrompt();
            input = Input.getInput();
            switch (input) {
                case 1 -> orderProducts.add(new OrderProduct(Input.getInt("Quantity: "),(Product) Util.select(DB.getInstance().getProducts(), "Select a product to add")));
                case 2 -> orderProducts.add(new OrderProduct(Input.getInt("Quantity: "), productCRUD.createProduct()));
            }
        } while (input != 0);
        if (orderProducts.isEmpty()) return null;
        return new Order(orderProducts);
    }

    public void listOrders(ArrayList<Order> orders) {
        Util.printArrayList(orders);
    }

    public Order getOrder(ArrayList<Order> orders) {
        OrderPrompts.orderSearchPrompt();
        int input = Input.getInput();
        return switch (input) {
            case 1 -> Searchable.search(orders, Input.getString("ID: "));
            case 2 -> Searchable.search(orders, LocalDate.parse(Input.getString("Date in format DD-MM-YYYY"), dateFormat));
            default -> throw new IllegalStateException("Unexpected value: " + input);
        };
    }

    public void updateOrder(ArrayList<Order> orders) {
        Order order = getOrder(orders);
        if (order == null) return;
        int input;
        do {
            OrderProduct orderProduct = (OrderProduct) Util.select(order.getProducts(), "Select a product to change");
            OrderPrompts.orderUpdatePrompt();
            input = Input.getInput();
            switch (input) {
                case 1 -> orderProduct.setOrderQty(Input.getInt("New quantity: "));
                case 2 -> orderProduct.setProduct((Product) Util.select(DB.getInstance().getProducts(), "Select a new product"));
            }
        } while (input != 0);
    }
}
