package classes.supplier;

import classes.Order;
import classes.product.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;


public class SupplierOrder implements Order {
    private final String ID;
    private ArrayList<Product> products;
    private final LocalDateTime date;
    private double total;

    public SupplierOrder(ArrayList<Product> products) {
        this.ID = UUID.randomUUID().toString();
        this.products = products;
        this.date = LocalDateTime.now();
        this.total = calculateTotal();
    }

    private String getID() {
        return ID;
    }

    public ArrayList<Product> getProducts() {
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
        for (Product product : products) {
            calculatedTotal += product.getPrice();
        }
        return calculatedTotal;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
        this.total = calculateTotal();
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "ID=" + ID +
                ", orderedProducts=" + products +
                ", date=" + date +
                ", totalOrder=" + total +
                '}';
    }
}
