package classes.customer;

import classes.Order;
import classes.product.Product;
import classes.Order;
import classes.product.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class CustomerOrder implements Order {

    private final ArrayList<Product> products;
    private final LocalDateTime PurchaseDate;
    private double Total;

    public CustomerOrder(ArrayList<Product> products){
        this.products = products;
        this.PurchaseDate = LocalDateTime.now();
        //TODO implement Total
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public LocalDateTime getPurchaseDate() {
        return PurchaseDate;
    }

    @Override
    public double getTotal() {
        return Total;
    }
}
