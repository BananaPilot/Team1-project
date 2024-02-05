package classes.customer;

import classes.shared.OrderProduct;
import classes.interfaces.Order;
import classes.interfaces.Searchable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;


public class CustomerOrder implements Order, Searchable {
    private final String ID;
    private ArrayList<OrderProduct> products;
    private final LocalDate date;
    private double total;


    public CustomerOrder(ArrayList<OrderProduct> products) {
        this.ID = UUID.randomUUID().toString();
        this.products = products;
        this.date = LocalDate.now();
        this.total = calculateTotal();
    }

    public String getID() {
        return ID;
    }

    public ArrayList<OrderProduct> getProducts() {
        return products;
    }

    public LocalDate getDate() {
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
        return "CustomerOrder{" +
                "ID=" + ID +
                ", orderedProducts=" + products +
                ", date=" + date +
                ", totalOrder=" + total +
                '}';
    }
}
