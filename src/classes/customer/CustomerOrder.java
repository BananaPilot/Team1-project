package classes.customer;

import java.time.LocalDateTime;
import java.util.ArrayList;

import classes.Order;

public class CustomerOrder implements Order {

  private final ArrayList<String> IDProducts;
  private final LocalDateTime PurchaseDate;
  private double Total;

  public CustomerOrder(ArrayList<String> IDProducts) {
    this.IDProducts = IDProducts;
    this.PurchaseDate = LocalDateTime.now();
    //TODO implement Total
  }

  public ArrayList<String> getIDProducts() {
    return IDProducts;
  }

  public LocalDateTime getPurchaseDate() {
    return PurchaseDate;
  }

  @Override
  public double getTotal() {
    return Total;
  }
}
