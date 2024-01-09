package Classes.Supplier;

import java.time.LocalDateTime;

public class Order {
  private int counter = 1;
  private final int ID;


  //QUI CI VANNO GLI "ORDERED PRODUCTS"/"PRODUCTS" MA NON SO COME ADDARLI, E' 1 ORA CHE BATTO LA TESTA SULLA
  //TASTIERA MA NON ESCE NULLA... non so se ci va qualcosa tra i constructor, devo ripassare un po' di roba


  private final LocalDateTime dateTime;
  private double totalOrder;

  public Order() {
    this.ID = incrementAndGet();
    this.dateTime = LocalDateTime.now();
    //this.totalOrder = totalOrder; check line 36
  }

  private int getID() {
    return ID;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public double getTotalOrder() {
    return totalOrder;
  }

  /*
  TODO
  automatic calculation of the total by taking all the prices from the class product and then calculating the total
   */
  private int incrementAndGet() {
    return counter++;
  }

  @Override
  public String toString() {
    return "Order ID: " + ID + "\n Date and time: " + dateTime + "Products: " + "Total: " + totalOrder;
  }
}
