package Classes.Supplier;

import Classes.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;


public class supplierOrder implements Order {
    private final String ID;
    private ArrayList<OrderedProduct> orderedProducts;
    private final LocalDateTime date;
    private double total;

    public supplierOrder(ArrayList<OrderedProduct> orderedProducts, double totalOrder) {
        this.ID = UUID.randomUUID().toString();
        this.orderedProducts = orderedProducts;
        this.date = LocalDateTime.now();
        // TODO implement Total
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

    @Override
    public double getTotal() {
        return total;
    }

    public void setOrderedProducts(ArrayList<OrderedProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "ID=" + ID +
                ", orderedProducts=" + orderedProducts +
                ", date=" + date +
                ", totalOrder=" + total +
                '}';
    }
}
