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

  public SupplierOrder(ArrayList<Product> orderedProducts, double totalOrder) {
    this.ID = UUID.randomUUID().toString();
    this.products = orderedProducts;
    this.date = LocalDateTime.now();
    //TODO implement total

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

  public void setProducts(ArrayList<Product> products) {
    this.products = products;
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
