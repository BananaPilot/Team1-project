package Classes.Supplier;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;


public class Order {
    private final String ID;
    private ArrayList<OrderedProduct> orderedProducts;
    private final LocalDateTime date;
    private double totalOrder;

    public Order(ArrayList<OrderedProduct> orderedProducts, double totalOrder) {
        this.ID = UUID.randomUUID().toString();
        this.orderedProducts = orderedProducts;
        this.date = LocalDateTime.now();
        this.totalOrder = totalOrder;

    }

    private String getID() {
        return ID;
    }

    public ArrayList<OrderedProduct> getOrderedProducts() {
        return orderedProducts;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getTotalOrder() {
        return totalOrder;
    }

    public void setOrderedProducts(ArrayList<OrderedProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public void setTotalOrder(double totalOrder) {
        this.totalOrder = totalOrder;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "ID=" + ID +
                ", orderedProducts=" + orderedProducts +
                ", date=" + date +
                ", totalOrder=" + totalOrder +
                '}';
    }
}
