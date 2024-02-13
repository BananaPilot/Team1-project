package classes.shared;

import classes.interfaces.Searchable;

import java.util.ArrayList;

public class Operations implements Searchable {
    private final ArrayList<Order> orders;
    private final double totalSpent;

    public Operations(ArrayList<Order> orders) {
        this.orders = orders;
        this.totalSpent = calculateTotalSpent();
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    private double calculateTotalSpent() {
        double total = 0;
        for (Order order : orders) {
            total += order.getTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Operations{" +
                "orders=" + orders +
                ", totalSpent=" + totalSpent +
                '}';
    }
}