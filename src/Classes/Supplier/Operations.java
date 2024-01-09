package Classes.Supplier;

import java.util.ArrayList;

public class Operations {
  private final ArrayList<Order> orders;
  private final double totalSpent;

  public Operations(ArrayList<Order> orders){
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
    for (Order order: orders){
      total += order.getTotalOrder();
    }
    return total;
  }
}
