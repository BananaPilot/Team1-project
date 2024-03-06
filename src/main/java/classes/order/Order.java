package classes.order;

import classes.shared.OrderProduct;
import classes.shared.Searchable;
import util.Util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;


public class Order extends Searchable {
    private final String ID;
    private ArrayList<OrderProduct> products;
    private final LocalDate date;
    private double total;


    public Order(ArrayList<OrderProduct> products) {
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

    public double getTotal() {
        return total;
    }

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
        return  "ID: " + ID + '\n' +
                "orderedProducts :" + Util.splitter(products) + '\n' +
                "date: " + date + '\n' +
                "totalOrder: " + total + '\n';
    }
}