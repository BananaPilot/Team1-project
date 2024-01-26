package classes.supplier;

import classes.OrderProduct;
import classes.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;


public class SupplierOrder implements Order {
    private final String ID;
    private ArrayList<OrderProduct> products;
    private final LocalDateTime date;
    private double total;

    public SupplierOrder(ArrayList<OrderProduct> products) {
        this.ID = UUID.randomUUID().toString();
        this.products = products;
        this.date = LocalDateTime.now();
        this.total = calculateTotal();
    }

    private String getID() {
        return ID;
    }

    public ArrayList<OrderProduct> getProducts() {
        return products;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public double getTotal() {
        return total;
    }

    @Override
    public double calculateTotal() {
        double calculatedTotal = 0;
        for (OrderProduct product : products) {
            calculatedTotal += product.getProduct().getPrice() * product.getOrderQty();
        }
        return calculatedTotal;
    }

    public void setProducts(ArrayList<OrderProduct> products) {
        this.products = products;
        this.total = calculateTotal();
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SupplierOrder{" +
                "ID=" + ID +
                ", orderedProducts=" + products +
                ", date=" + date +
                ", totalOrder=" + total +
                '}';
    }
}
